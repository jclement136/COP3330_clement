import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

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

        list.view();

        writeTaskData();
    }

    private boolean shouldContinue(String userInput) {
        return userInput.toLowerCase().startsWith("y");
    }

    private static String askShouldContinue() {
        System.out.println("Do you wish to enter a new task? (y/n):");
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

    public static void main(String[] args) {
        App application = new App();

        application.processTaskData();
    }



}
