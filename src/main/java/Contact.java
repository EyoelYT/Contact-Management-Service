public class Contact {
    private final String id;
    private String firstName = "";
    private String lastName = "";
    private String phone = "";
    private String address = "";

    public Contact(String Id) {

        validateId(Id);
        this.id = Id;
    }
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        validateContact(contactId, firstName, lastName, phone, address);

        this.id = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;

    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String number) {
        validatePhone(number);
        this.phone = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    private void validateContact(String id, String firstName, String lastName, String phone, String address) {
        validateId(id);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);
    }

    private void validateId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null and must be 10 characters or less.");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less.");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less.");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone cannot be null and must be exactly 10 digits.");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less.");
        }
    }
}

