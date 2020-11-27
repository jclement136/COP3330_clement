import java.time.LocalDate;

public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        if (firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank())
            throw new InvalidContactException("A contact item must contain one of the four fields.");
        else {
            setFirstName(firstName);
            setLastName(lastName);
            setPhoneNumber(phoneNumber);
            setEmailAddress(emailAddress);
        }
    }

    // SETTERS
    protected void setFirstName(String firstName) {
        if (firstName == "" && lastName == "" && phoneNumber == "" && emailAddress == "")
            throw new InvalidContactException("A contact item cannot contain four blank fields.");
        else
            this.firstName = firstName;
    }
    protected void setLastName(String lastName) {
        if (firstName == "" && lastName == "" && phoneNumber == "" && emailAddress == "")
            throw new InvalidContactException("A contact item cannot contain four blank fields.");
        else
            this.lastName = lastName;
    }
    protected void setPhoneNumber(String phoneNumber) {
        if (firstName == "" && lastName == "" && phoneNumber == "" && emailAddress == "")
            throw new InvalidContactException("A contact item cannot contain four blank fields.");
        else if (isPhoneNumberValid(phoneNumber))
            this.phoneNumber = phoneNumber;
        else
            throw new InvalidPhoneNumberException("Invalid phone number. Format must be 123-456-7890.");
    }
    protected void setEmailAddress(String emailAddress) {
        if (firstName == "" && lastName == "" && phoneNumber == "" && emailAddress == "")
            throw new InvalidContactException("A contact item cannot contain four blank fields.");
        else if (isEmailAddressValid(emailAddress))
            this.emailAddress = emailAddress;
        else
            throw new InvalidEmailAddressException("Invalid email address. Format must be email@address.com.");
    }

    // GETTERS
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String toString() {
        return firstName+ "\n" + lastName + "\n" + phoneNumber + "\n" + emailAddress;
    }

    // VALIDITY
    protected boolean isPhoneNumberValid (String phoneNumber) {
        // checks for valid date format 123-465-7890
        if (phoneNumber.isBlank())
            return true;

        else if (phoneNumber.length() != 12) {
            return false;
        }
        // preliminary hyphen check
        else if (phoneNumber.charAt(3) != '-' || phoneNumber.charAt(7) != '-') {
            return false;
        }
        // loop to check each index. skip hyphens during digit check. return true if entire string passes test.
        else {
            for (int i = 0; i < 12; i++) {
                if (Character.isDigit(phoneNumber.charAt(i))) {
                    if (i == 3 || i == 7) {
                        if (phoneNumber .charAt(i) == '-')
                            continue;
                        else
                            return false;
                    }
                    if (i == 11)
                        return true;
                    else
                        continue;
                }
            }
        }
        return false;
    }
    protected boolean isEmailAddressValid(String emailAddress) {
        if (emailAddress.isBlank())
            return true;
        else if (emailAddress.indexOf('@') == -1)
           return false;
       else
           return true;
    }

    // EXCEPTIONS
    class InvalidContactException extends IllegalArgumentException {
        public InvalidContactException(String msg) {
            super(msg);
        }
    }
    class InvalidPhoneNumberException extends IllegalArgumentException {
        public InvalidPhoneNumberException(String msg) {
            super(msg);
        }
    }
    class InvalidEmailAddressException extends IllegalArgumentException {
        public InvalidEmailAddressException(String msg) {
            super(msg);
        }
    }
}