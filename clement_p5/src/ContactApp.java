import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ContactApp {

    private static Scanner input = new Scanner(System.in);
    private ContactList list;
    public ContactApp() {
        list = new ContactList();
    }

    protected void contactListMainMenu() {
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
                list = new ContactList();
                System.out.println("New contact list created.");
                contactMenu();
                break;
            case "2":
                while (true) {
                    try {
                        Scanner input = new Scanner(Paths.get("contacts.txt"));
                        list.load("contacts.txt");
                        System.out.println("Contact list loaded.");
                        contactMenu();
                        break;
                    } catch (NoSuchFileException ex) {
                        System.out.println("No contact list saved yet. Please create a new contact list.");
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                break;
            case "3":
                ;
                break;
            default:
                System.out.println("Please enter a valid list option.");
                break;
        }
    }

    private void contactMenu() {
        String response = "";

        while (!response.equals("6")) {
            printContactMenu();
            response = input.nextLine();
            processContactMenuOption(response);
        }
    }

    private void printContactMenu() {
        System.out.println("Task list operations menu");
        System.out.println("----------------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to main menu");
    }

    private void processContactMenuOption(String response) {
        switch (response) {
            case "1":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to view. Please add one first. Returning to contact menu...");
                else
                    list.view();
                break;
            case "2":
                processContactAdd();
                break;
            case "3":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to edit. Please add one first. Returning to main menu...");
                else
                    processContactEdit();
                break;
            case "4":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to remove. Please add one first. Returning to main menu...");
                else
                    processContactRemove();
                break;
            case "5":
                if (list.getListSize() == 0)
                    System.out.println("There are no items in the list to save. Please add one first. Returning to main menu...");
                else
                    list.save("contacts.txt");
                break;
            case "6":
                ;
                break;
            default:
                System.out.println("Please enter a valid list option.");
                break;
        }
    }

    private void processContactAdd() {
        while(askContinueAdding()) {
            ContactItem contact = gatherContactData();
            storeContactData(contact);
        }
    }

    private ContactItem gatherContactData() {
        String firstName = getContactFirstName();
        String lastName = getContactLastName();
        String phoneNumber = getContactPhoneNumber();
        String emailAddress = getContactEmailAddress();

        ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);

        return contact;
    }
    private String getContactFirstName() {
        System.out.println("Enter the contact's first name:");
        return input.nextLine();
    }
    private String getContactLastName() {
        System.out.println("Enter the contact's last name:");
        return input.nextLine();
    }
    private String getContactPhoneNumber() {
        System.out.println("Enter the contact's phone number (format must be 123-456-7890):");
        return input.nextLine();
    }
    private String getContactEmailAddress() {
        System.out.println("Enter the contact's email address (format must be email@address.com):");
        return input.nextLine();
    }

    private void storeContactData(ContactItem contact) {
        list.add(contact);
    }

    private boolean askContinueAdding() {
        System.out.println("Would you like to add a new contact? (y/n):");

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


    private void processContactEdit() {
        int size = list.getListSize();
        String response;
        list.view();

        while(true) {
            System.out.println("Which contact will you edit?");
            response = input.nextLine();
            int listOption = Integer.parseInt(response);
            if (listOption <= list.getListSize() && listOption > 0) {
                editContactData(listOption);
                break;
            }
            else
                System.out.println("Please enter a valid list option.");
        }
    }

    private void editContactData(int listOption) {
        String revision;

        System.out.println("Type the contact's new first name.");
        revision = input.nextLine();
        list.editFirstName(listOption, revision);
        System.out.println("First name successfully updated.");

        System.out.println("Type the contact's new last name.");
        revision = input.nextLine();
        list.editLastName(listOption, revision);
        System.out.println("Last name successfully updated.");

        System.out.println("Type the contact's new phone number.");
        revision = input.nextLine();
        list.editPhoneNumber(listOption, revision);
        System.out.println("Phone number successfully updated.");


        System.out.println("Type the contact's new email address.");
        revision = input.nextLine();
        list.editEmailAddress(listOption, revision);
        System.out.println("Email address successfully updated.");
    }

    private void processContactRemove() {
        int size = list.getListSize();
        String response;
        list.view();

        while (true) {
            System.out.println("Which contact will you remove?");
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