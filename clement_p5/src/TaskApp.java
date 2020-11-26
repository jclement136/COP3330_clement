import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        if (response.equals("1")) {
            list = new TaskList();
            System.out.println("New task list created.");
            taskMenu();
        }
        else if (response.equals("2")) {
            list.load("output.txt");
            System.out.println("Task list loaded.");
            taskMenu();
        }
        else if (response.equals("3"))
            ;
        else
            System.out.println("Please enter a valid list option.");
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
        if (response.equals("1")) {
            if (list.getListSize() == 0)
                System.out.println("There are no items in the list to view. Please add one first. Returning to main menu...");
            else
                list.view();
        }
        else if (response.equals("2")) {
            processTaskAdd();
        }
        else if (response.equals("3")) {
            if (list.getListSize() == 0)
                System.out.println("There are no items in the list to edit. Please add one first. Returning to main menu...");
            else
                processTaskEdit();
        }
        else if (response.equals("4")) {
            if (list.getListSize() == 0)
                System.out.println("There are no items in the list to remove. Please add one first. Returning to main menu...");
            else
                processTaskRemove();
        }
        else if (response.equals("5")) {
            if (list.getListSize() == 0)
                System.out.println("There are no items in the list to save. Please add one first. Returning to main menu...");
            else
                list.save("output.txt");
        }
        else if (response.equals("6"))
            ;
        else
            System.out.println("Please enter a valid list option.");
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
        Boolean complete = getTaskCompletionStatus();

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
        int size = list.getListSize();
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
        int size = list.getListSize();
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


/*

    private boolean askProceed() {
        System.out.println("Would you like to return to the main menu? (y/n):");
        String response = input.nextLine();

        if (response.toLowerCase().startsWith("y"))
            return true;
        else if (response.toLowerCase().startsWith("n"))
            return false;
        else
            throw new IllegalArgumentException("Response must be either y/n.");
    }

    private void frankenstein() {
        else if (selection == 5) // save
        {
            if (list.findSize() == 0)
                System.out.println("There are no items in the list to save. Please add one first. Returning to main menu...");
            else {
                list.write("output.txt");
                System.out.println("List saved as text file 'output.txt'.");
            }
        }
        else if (selection == 6) // load
        {
            System.out.println("Enter the filename to load:");
            String filename = input.nextLine();
            File f = new File(filename);

            try {
                list.load(f);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Task list has been loaded.");
        }
    }

        private void editTask() {

        // select a list option
        int size = list.getListSize();
        System.out.println("There are currently " + size + " items on the task list. Enter a task number to begin editing it, or type '0' to exit to the main menu.");
        String answer = input.nextLine();
        int response = Integer.parseInt(answer);

        if (response == 0) {
            System.out.println("Returning to menu...");
        }
        else if (response > 0 && response <= size) {
            System.out.println("Task number " + response + " will now be edited. Select what to edit: (1) title (2) description (3) due date (4) mark complete (5) unmark complete");

            String nextAnswer = input.nextLine();
            int selection = Integer.parseInt(nextAnswer);

            if (selection == 1) {
                System.out.println("Type your new task title.");
                list.editTitle(response, input.nextLine());
                System.out.println("Task title successfully edited.");
            }
            else if (selection == 2) {
                System.out.println("Type your new task description.");
                list.editDescription(response, input.nextLine());
                System.out.println("Task description successfully edited.");
            }
            else if (selection == 3) {
                System.out.println("Type your new task due date.");
                list.editDueDate(response, input.nextLine());
                System.out.println("Task due date successfully edited.");
            }
            else if (selection == 4) {
                list.markComplete(response);
                System.out.println("Task marked as complete.");
            }
            else if (selection == 5) {
                list.unmarkComplete(response);
                System.out.println("Task unmarked as complete.");
            }
            else {
                System.out.println("That is not a valid option.");
            }
        }
        else {
            System.out.println("That is not a valid task number.");
        }
    }
     */


}

