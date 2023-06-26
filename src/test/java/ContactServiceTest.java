import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testSuccessfulCreationWithLastNameOfLength10() {
        Contact contact = new Contact("0123456789", "Eyoel", "LastIs10Ok", "0123456789", "Address");
        assertEquals("LastIs10Ok", contact.getLastName());
    }

    @Test
    public void testAddContact() {
        contactService.addContact("D8436");
        Vector<Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(1, contacts.size());
        Assertions.assertEquals("D8436", contacts.get(0).getId());
    }

    @Test
    public void testAddContactWithExistingId() {
        contactService.addContact("D8436");
        contactService.addContact("D8436");
        Vector<Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(1, contacts.size());
        Assertions.assertEquals("D8436", contacts.get(0).getId());
    }

    @Test
    public void testUpdateContact() {
        contactService.addContact("D8436");
        contactService.updateContact("D8436", "Eyoel", "Tesfu", "0123456789", "3400 Main St");
        Vector<Contact> contacts = contactService.getContacts();
        Assertions.assertEquals("Eyoel", contacts.get(0).getFirstName());
        Assertions.assertEquals("Tesfu", contacts.get(0).getLastName());
        Assertions.assertEquals("0123456789", contacts.get(0).getPhoneNumber());
        Assertions.assertEquals("3400 Main St", contacts.get(0).getAddress());
    }

    @Test
    public void testUpdateContactWithNonExistingId() {
        contactService.updateContact("D8436", "Eyoel", "Tesfu", "0123456789", "3400 Main St");
        Vector<Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(0, contacts.size());
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact("D8345");
        contactService.deleteContact("D8345");
        Vector<Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(0, contacts.size());
    }

    @Test
    public void testDeleteContactWithNonExistingId() {
        contactService.deleteContact("D8345");
        Vector<Contact> contacts = contactService.getContacts();
        Assertions.assertEquals(0, contacts.size());
    }

}