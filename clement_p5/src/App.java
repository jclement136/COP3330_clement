import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);

    private static void printAppMenu() {
        System.out.println("Select Your Application");
        System.out.println("----------------");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
    }

    private static void processAppMenuOption(String response) {
        if (response.equals("1")) {
            TaskApp taskApplication = new TaskApp();
            taskApplication.taskListMainMenu();
        }
        else if (response.equals("2")) {
            ContactApp contactApplication = new ContactApp();
            contactApplication.contactListMainMenu();
        }
        else if (response.equals("3"))
            System.exit(0);
        else
            System.out.println("Please enter a valid list option.");
    }

    public static void main(String[] args) {
        String response = "";

        while (!response.equals("3")) {
            printAppMenu();
            response = input.nextLine();
            processAppMenuOption(response);
        }
    }
}