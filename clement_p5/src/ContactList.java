import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ContactList {

    List<ContactItem> list;

    public ContactList() {
        list = new ArrayList<>();
    }

    public void add(ContactItem contact) {
        list.add(contact);
    }

    public void remove(int listOption) {
        int index = listOption - 1;
        if (list.size() <= 0) {
            throw new IndexOutOfBoundsException("Cannot remove an item because the contact list is empty.");
        }
        else {
            list.remove(index);
        }
    }

    public int getListSize() {
        return list.size();
    }

    public void view() {
        try {
            ContactItem contact;
            System.out.format("Contacts%n%n");
            for (int i = 0; i < list.size(); i++) {
                contact = list.get(i);
                System.out.format("[%d] ", i + 1);
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName());
                System.out.println("Phone number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmailAddress());
                if (i < list.size())
                    System.out.format("%n");
            } }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save(String filename) {
        try(Formatter output = new Formatter(filename)) {
            output.format("Contacts%n");
            for(ContactItem contact : list) {
                output.format("%s%n", contact.getFirstName());
                output.format("%s%n", contact.getLastName());
                output.format("%s%n", contact.getPhoneNumber());
                output.format("%s%n", contact.getEmailAddress());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void load(String filename) {
        List<ContactItem> backupList = list;
        list = new ArrayList<>();

        try(Scanner input = new Scanner(Paths.get(filename))) {
            String header = input.nextLine();
            if (header.equalsIgnoreCase("contacts")) {
                while(input.hasNext()) {
                    String firstName = input.nextLine();
                    String lastName = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String emailAddress = input.nextLine();

                    ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                    list.add(contact);
                }
            }
            else {
                list = backupList;
                throw new IllegalArgumentException("Task file not found. No task list loaded.");
            }
        } catch (FileNotFoundException e){
            list = backupList;
            throw new IllegalArgumentException("Task file not found. No task list loaded.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editFirstName(int listOption, String newFirstName) {
        int index = listOption - 1;
        ContactItem contact = list.get(index);
        contact.setFirstName(newFirstName);
    }

    public void editLastName(int listOption, String newLastName) {
        int index = listOption - 1;
        ContactItem contact = list.get(index);
        contact.setLastName(newLastName);
    }

    public void editPhoneNumber(int listOption, String newPhoneNumber) {
        int index = listOption - 1;
        ContactItem contact = list.get(index);
        contact.setPhoneNumber(newPhoneNumber);
    }

    public void editEmailAddress(int listOption, String newEmailAddress) {
        int index = listOption - 1;
        ContactItem contact = list.get(index);
        contact.setEmailAddress(newEmailAddress);
    }

}
