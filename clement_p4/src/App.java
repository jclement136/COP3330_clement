import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

// HANDLES USER INTERACTION
// use scanners to call on and modify task item, task list
public class App {

    private static Scanner input = new Scanner(System.in);

    private TaskList list;

    public App() {
        list = new TaskList();
    }

    private void processTaskData() {
        while(shouldContinue(askShouldContinue())) {
            TaskItem task = getTaskData();
            storeTaskData(task);
        }
        return;
    }

    private void processRemoval() {
            int size = list.findSize();
            System.out.println("There are currently " + size + " items on the task list. Enter a task number to remove it, or type '0' to exit to the main menu.");
            String answer = input.nextLine();
            int response = Integer.parseInt(answer);

            if (response == 0) {
                System.out.println("Returning to menu...");
            }
            else if (response > 0 && response <= size) {
                list.remove(response);
                System.out.println("Task number " + response + " deleted.");
            }
            else {
                System.out.println("That is not a valid task number.");
            }
    }

    private boolean shouldContinue(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    private static String askShouldContinue() {
        System.out.println("Would you like to add a new task? (y/n):");
        return input.nextLine();
    }

    private void writeTaskData() {
        list.write("output.txt");
    }

    private void storeTaskData(TaskItem task) {
        list.add(task);
    }

    private TaskItem getTaskData() {
        String title = getTaskTitle();
        String description = getTaskDescription();
        String dueDate = getTaskDueDate();
        String completionStatus = getTaskCompletionStatus();

        TaskItem task = new TaskItem(title, description, dueDate, completionStatus);

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

    private String getTaskCompletionStatus() {
        System.out.println("Enter whether the task is completed (y/n):");
        return input.nextLine();
    }

    private void printIntroduction() {
        System.out.println("Welcome to the Task List Manager. Please select an option below by typing its number to the command line.");
        System.out.println("1. ADD tasks to current or new list.  ||  2. REMOVE tasks from current list.    ||  3. VIEW the current task list.");
        System.out.println("4. EDIT a task from current list.     ||  5. SAVE current list to a text file.  ||  6. LOAD an existing list from a text file.");
        System.out.println("7. EXIT.");
        System.out.println("Which action would you like to perform?");
    }

    private int getSelection() {
        String selection = input.nextLine();
        return Integer.parseInt(selection);
    }

    private String askShouldReturn() {
        System.out.println("Go to the main menu? (y/n):");
        return input.nextLine();
    }

    private boolean shouldReturn(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    private void editTaskData() {
        // select a list option
        int size = list.findSize();
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
        // choose what part to edit

        // type your edit

        // edit saved

        // return
    }

    private void fileManager() {

        boolean proceed = true;

        while(proceed) {

            printIntroduction();
            String response = input.nextLine();
            int selection = Integer.parseInt(response);

            if (selection == 1) // add
            {
                processTaskData();
            }
            else if (selection == 2) // remove
            {
                if (list.findSize() == 0)
                {
                    System.out.println("There are no items in the list to remove. Please add one first. Returning to main menu...");
                }
                else
                    processRemoval();
            }
            else if (selection == 3) // view
            {
                if (list.findSize() == 0)
                    System.out.println("There are no items in the list to view. Please add one first. Returning to main menu...");
                else
                    list.view();
            }
            else if (selection == 4) // edit // title, desc, due date, mark comp, unmark comp
            {
                if (list.findSize() == 0)
                    System.out.println("There are no items in the list to edit. Please add one first. Returning to main menu...");
                else
                    editTaskData();
            }
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
            else if (selection == 7) // exit
                break;
            else
                System.out.println("Please select one of the options above."); }

        System.out.println("Exiting the Task List Manager...");

        }

    public static void main(String[] args) {

        App application = new App();

        application.fileManager();
    }



}
