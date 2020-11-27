import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    // Contact item creation
    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(ContactItem.InvalidContactException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("", "Lastname", "123-456-7890", "email@address.com");
        assertEquals("", item.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("Firstname", "", "123-456-7890", "email@address.com");
        assertEquals("", item.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("Firstname", "Lastname", "", "email@address.com");
        assertEquals("", item.getPhoneNumber());
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("Firstname", "Lastname", "123-456-7890", "");
        assertEquals("", item.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow(() -> new ContactItem("Firstname", "Lastname", "123-456-7890", "email@address.com"));
    }

    @Test
    public void creationFailsWithInvalidPhone() {
        assertThrows(ContactItem.InvalidPhoneNumberException.class, () -> new ContactItem("Firstname", "Lastname", "1234567890", "email@address.com"));
    }

    @Test
    public void creationFailsWithInvalidEmail() {
        assertThrows(ContactItem.InvalidEmailAddressException.class, () -> new ContactItem("Firstname", "Lastname", "123-456-7890", "email"));
    }


    // Editing
    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("Firstname", "", "", "");
        assertThrows(ContactItem.InvalidContactException.class, () -> contact.setFirstName(""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("", "Lastname", "123-456-7890", "email@address.com");
        contact.setFirstName("Firstname");
        assertEquals("Firstname", contact.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("Firstname", "", "123-456-7890", "email@address.com");
        contact.setLastName("Lastname");
        assertEquals("Lastname", contact.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem("Firstname", "Lastname", "", "email@address.com");
        contact.setPhoneNumber("123-456-7890");
        assertEquals("123-456-7890", contact.getPhoneNumber());
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("Firstname", "Lastname", "123-456-7890", "");
        contact.setEmailAddress("email@address.com");
        assertEquals("email@address.com", contact.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("Firstname", "Lastname", "123-456-7890", "email@address.com");
        contact.setFirstName("Name");
        assertEquals("Name", contact.getFirstName());
    }


    // Misc.
    @Test
    public void testToString() {
        ContactItem contact = new ContactItem("Firstname", "Lastname", "123-456-7890", "email@address.com");
        String contactString = contact.toString();
        assertEquals(contact.toString(), "Firstname\nLastname\n123-456-7890\nemail@address.com");
    }
}
