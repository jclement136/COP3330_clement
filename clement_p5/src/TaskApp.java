import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskApp {

    private static Scanner input = new Scanner(System.in);
    private TaskList list;
    public TaskApp() {
        list = new TaskList();
    }

    protected void taskListMainMenu() {
        String response = "";
        while (!response.equals("3")) {
            printMainMenu();
            response = input.nextLine();
            processMainMenuOption(response);
        }
    }

    private void printMainMenu() {
        System.out.println("Main menu");
        System.out.println("----------------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit to application select screen");
    }

    private void processMainMenuOption(String response) {
        switch (response) {
            case "1":
                list = new TaskList();
                System.out.println("New task list created.");
                taskMenu();
                break;
            case "2":
                while (true) {
                    try {
                        Scanner input = new Scanner(Paths.get("tasks.txt"));
                        list.load("tasks.txt");
                        System.out.println("Task list loaded.");
                        taskMenu();
                        break;
                    } catch (NoSuchFileException ex) {
                        System.out.println("No task list saved yet. Please create a new task list.");
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                break;
            case "3":
                break;
            default:
                System.out.println("Please enter a valid list option.");
                break;
        }
    }

    private void taskMenu() {
        String response = "";

        while (!response.equals("6")) {
            printTaskMenu();
            response = input.nextLine();
            processTaskMenuOption(response);
        }
    }

    private void printTaskMenu() {
        System.out.println("Task list operations menu");
        System.out.println("----------------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to main menu");
    }

    private void processTaskMenuOption(String response) {
        switch (response) {
            case "1":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to view. Please add one first. Returning to task menu...");
                else
                    list.view();
                break;
            case "2":
                processTaskAdd();
                break;
            case "3":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to edit. Please add one first. Returning to main menu...");
                else
                    processTaskEdit();
                break;
            case "4":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to remove. Please add one first. Returning to main menu...");
                else
                    processTaskRemove();
                break;
            case "5":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to save. Please add one first. Returning to main menu...");
                else
                    list.save("tasks.txt");
                break;
            case "6":
                break;
            default:
                System.out.println("Please enter a valid list option.");
                break;
        }
    }

    private void processTaskAdd() {
        while(askContinueAdding()) {
            TaskItem task = gatherTaskData();
            storeTaskData(task);
        }
    }

    private TaskItem gatherTaskData() {
        String title = getTaskTitle();
        String description = getTaskDescription();
        String dueDate = getTaskDueDate();
        boolean complete = getTaskCompletionStatus();

        TaskItem task = new TaskItem(title, description, dueDate, complete);

        return task;
    }
    private String getTaskTitle() {
        System.out.println("Enter the task title:");
        return input.nextLine();
    }
    private String getTaskDescription() {
        System.out.println("Enter the task description (can be blank):");
        return input.nextLine();
    }
    private String getTaskDueDate() {
        System.out.println("Enter the task due date (format must by YYYY-MM-DD):");
        return input.nextLine();
    }
    private boolean getTaskCompletionStatus() {
        System.out.println("Enter whether the task is completed (y/n):");
        String response = input.nextLine();
        if (response.toLowerCase().startsWith("y"))
            return true;
        else if (response.toLowerCase().startsWith("n"))
            return false;
        else
            throw new IllegalArgumentException("Response must be either y/n.");
    }

    private void storeTaskData(TaskItem task) {
        list.add(task);
    }

    private boolean askContinueAdding() {
        System.out.println("Would you like to add a new task? (y/n):");

        String response;

        while(true) {
            response = input.nextLine();
            if (response.toLowerCase().startsWith("y"))
                return true;
            else if (response.toLowerCase().startsWith("n"))
                return false;
            else
                System.out.println("Response must be either y/n.");
        }
    }

    private void processTaskEdit() {
        String response;
        list.view();

        while(true) {
            System.out.println("Which task will you edit?");
            response = input.nextLine();
            int listOption = Integer.parseInt(response);
            if (listOption <= list.getListSize() && listOption > 0) {
                editTaskData(listOption);
                break;
            }
            else
                System.out.println("Please enter a valid list option.");
        }
    }

    private void editTaskData(int listOption) {
        String revision;

        System.out.println("Type your new task title.");
        revision = input.nextLine();
        list.editTitle(listOption, revision);
        System.out.println("Title successfully updated.");

        System.out.println("Type your new task description.");
        revision = input.nextLine();
        list.editDescription(listOption, revision);
        System.out.println("Description successfully updated.");

        System.out.println("Type your new task due date.");
        revision = input.nextLine();
        list.editDueDate(listOption, revision);
        System.out.println("Due date successfully updated.");


        System.out.println("Type whether or not the task is complete (y/n).");
        revision = input.nextLine();
        list.editCompletionStatus(listOption, revision);
        System.out.println("Due date successfully updated.");
    }

    private void processTaskRemove() {
        String response;
        list.view();

        while (true) {
            System.out.println("Which task will you remove?");
            response = input.nextLine();
            int listOption = Integer.parseInt(response);
            if (listOption <= list.getListSize() && listOption > 0) {
                list.remove(listOption);
                break;
            }
            else
                System.out.println("Please enter a valid list option.");
        }
    }
}