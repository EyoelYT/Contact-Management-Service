import java.util.Vector;

public class ContactService {
    private Vector<Contact> contacts = new Vector<Contact>();

    // Adds the contact after verifying that there is no pre-existing ID in the vector list.
    public void addContact(String Id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.elementAt(i).getId().equals(Id)) {
                System.out.println("This contact is already registered in the list.");
                return;
            }
        }
        Contact newContact = new Contact(Id);
        contacts.add(newContact);
    }

    // Searches for a contact with matching "ID" and updates the contact object's variables
    public void updateContact(String Id, String firstName, String lastName, String phoneNumber, String address) {

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.elementAt(i).getId().equals(Id)) {
                contacts.elementAt(i).setFirstName(firstName);
                contacts.elementAt(i).setLastName(lastName);
                contacts.elementAt(i).setPhoneNumber(phoneNumber);
                contacts.elementAt(i).setAddress(address);
                return;
            }
        }
        System.out.println("There is no contact with id " + Id + " in the list.");
    }

    // Searches for a contact with matching "ID" and removes it
    public void deleteContact(String Id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.elementAt(i).getId().equals(Id)) {
                contacts.remove(contacts.elementAt(i));
                System.out.println("Removed the contact with id: " + Id);
                return;
            }
        }
        System.out.println("There is no Contact with the id of " + Id + "in the list.");
    }

    public Vector<Contact> getContacts() {
        return contacts;
    }
}
