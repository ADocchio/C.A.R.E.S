package hospital.ui.users;

import hospital.ui.warnings.WarningManager;

import java.io.Serializable;

/**
 * Represents a person with basic personal information. This class serves as a foundation for
 * representing individuals in a system, capturing common attributes such as name, date of birth,
 * permanent address, and phone number. It can be extended or used as part of other classes to
 * include individuals within
 */
public class Person implements Serializable {

    /**
     * The person's first name.
     */
    private String firstName;

    /**
     * The person's last name.
     */
    private String lastName;

    /**
     * The person's date of birth, expected in the format MM/DD/YYYY.
     */
    private String dob;

    /**
     * The person's permanent address.
     */
    private String permAdd;

    /**
     * The person's phone number, expected in the format 000-000-0000.
     */
    private String phoneNum;

    /**
     * Constructs a new instance of Person with specified personal details.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param dob       The date of birth of the person, formatted as MM/DD/YYYY.
     * @param permAdd   The permanent address of the person.
     * @param phoneNum  The phone number of the person, formatted as 000-000-0000.
     */
    public Person(String firstName, String lastName, String dob, String permAdd, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.permAdd = permAdd;
        this.phoneNum = phoneNum;
    }

    /**
     * Retrieves the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the first name of the person.
     *
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the person.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the last name of the person.
     *
     * @param lastName The new last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the date of birth of the person.
     *
     * @return The date of birth, formatted as MM/DD/YYYY.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the person. Validates the input to ensure it matches
     * the expected format MM/DD/YYYY. If the input is invalid, a warning is displayed.
     *
     * @param dob The new date of birth to set, formatted as MM/DD/YYYY.
     */
    public void setDob(String dob) {
        if (dob.matches("^\\d{2}/\\d{2}/\\d{4}$") || dob.equals("")) {
            this.dob = dob;
        } else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, format should be MM/DD/YYYY");
        }
    }

    /**
     * Retrieves the permanent address of the person.
     *
     * @return The permanent address.
     */
    public String getPermAdd() {
        return permAdd;
    }

    /**
     * Updates the permanent address of the person.
     *
     * @param permAdd The new permanent address to set.
     */
    public void setPermAdd(String permAdd) {
        this.permAdd = permAdd;
    }

    /**
     * Retrieves the phone number of the person.
     *
     * @return The phone number, formatted as 000-000-0000.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the phone number of the person. Validates the input to ensure it matches
     * the expected format 000-000-0000. If the input is invalid, a warning is displayed.
     *
     * @param phoneNum The new phone number to set, formatted as 000-000-0000.
     */
    public void setPhoneNum(String phoneNum) {
        if (phoneNum.matches("^\\d{3}-\\d{3}-\\d{4}$") || phoneNum.equals("")) {
            this.phoneNum = phoneNum;
        } else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, format should be 000-000-0000");
        }
    }
}
