import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ContactListTest {
    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(0, list.getListSize());
    }

    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        list.add(contact);
        assertEquals(1, list.getListSize());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        list.add(contact);
        list.remove(1);
        assertEquals(0, list.getListSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.editFirstName(1, "Name"));
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("Firstname","","","");
        ContactList list = new ContactList();
        list.add(contact);
        assertThrows(ContactItem.InvalidContactException.class, () -> list.editFirstName(1, ""));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        ContactList list = new ContactList();
        list.add(contact);
        assertDoesNotThrow(() -> list.editFirstName(1, "Name"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        ContactList list = new ContactList();
        list.add(contact);

        list.editFirstName(1, "");
        assertEquals("", contact.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        ContactList list = new ContactList();
        list.add(contact);

        list.editLastName(1, "");
        assertEquals("", contact.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        ContactList list = new ContactList();
        list.add(contact);

        list.editPhoneNumber(1, "");
        assertEquals("", contact.getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        ContactList list = new ContactList();
        list.add(contact);
        list.editEmailAddress(1, "");
        assertEquals("", contact.getEmailAddress());
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactItem contact = new ContactItem("Firstname","Lastname","123-456-7890","email@address.com");
        ContactList list = new ContactList();
        list.add(contact);
        list.add(contact);

        System.out.println("Current list:");
        list.view();

        System.out.println("Saving file...");
        list.save("output.txt");
        System.out.println("List saved to a file.");

        System.out.println("Loading saved file...");
        list.load("output.txt");
        System.out.println("File loaded. Viewing loaded file...");
        list.view();

        assertEquals(list.getListSize(), 2);
    }
}
