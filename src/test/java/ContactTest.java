import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    public void testContactConstructorWithValidArguments() {
        Contact contact = new Contact("D8345", "Eyoel", "Tesfu", "0123456789", "3400 Main St");
        assertEquals("D8345", contact.getId());
        assertEquals("Eyoel", contact.getFirstName());
        assertEquals("Tesfu", contact.getLastName());
        assertEquals("0123456789", contact.getPhoneNumber());
        assertEquals("3400 Main St", contact.getAddress());
    }

    @Test
    public void testContactConstructorWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ContactIdWithMoreThan10Characters");
        });
    }

    @Test
    public void testContactConstructorWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("D8345", null, "Tesfu", "0123456789", "3400 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("D8345", "FirstNameWithMoreThan10Characters", "Tesfu", "0123456789", "3400 Main St");
        });
    }

    @Test
    public void testSetFirstNameWithValidName() {
        Contact contact = new Contact("D8345");
        contact.setFirstName("Eyoel");
        assertEquals("Eyoel", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameWithInvalidName() {
        Contact contact = new Contact("D8345");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("FirstNameWithMoreThan10Characters");
        });
    }

    @Test
    public void testSetLastNameWithValidName() {
        Contact contact = new Contact("D8345");
        contact.setLastName("Tesfu");
        assertEquals("Tesfu", contact.getLastName());
    }

    @Test
    public void testSetLastNameWithInvalidName() {
        Contact contact = new Contact("D8345");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("LastNameWithMoreThan10Characters");
        });
    }

    @Test
    public void testSetPhoneNumberWithValidNumber() {
        Contact contact = new Contact("D8345");
        contact.setPhoneNumber("0123456789");
        assertEquals("0123456789", contact.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumberWithInvalidNumber() {
        Contact contact = new Contact("D8345");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("InvalidPhoneNumber");
        });
    }

    @Test
    public void testSetAddressWithValidAddress() {
        Contact contact = new Contact("D8345");
        contact.setAddress("3400 Main St");
        assertEquals("3400 Main St", contact.getAddress());
    }

    @Test
    public void testSetAddressWithInvalidAddress() {
        Contact contact = new Contact("D8345");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("AddressWithMoreThan30Characters||AddressWithMoreThan30Characters");
        });
    }
}