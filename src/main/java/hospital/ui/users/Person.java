package hospital.ui.users;

import java.io.Serializable;

/**
 * Represents a person with basic personal information. This class serves as a foundation for
 * representing individuals in a system, capturing common attributes such as name, date of birth,
 * permanent address, and phone number. It can be extended or used as part of other classes to
 * include individuals within
 */
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String dob;
    private String permAdd;
    private String phoneNum;

    /**
     * Constructs a new Person instance with the specified personal details.
     * This constructor initializes a person with essential information needed for identification
     * and contact purposes within various systems or applications.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param dob       The date of birth of the person.
     * @param permAdd   The permanent address of the person.
     * @param phoneNum  The phone number of the person.
     */
    public Person(String firstName, String lastName, String dob, String permAdd, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.permAdd = permAdd;
        this.phoneNum = phoneNum;
    }

    /**
     * Returns the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName The new first name to be set for the person.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName The new last name to be set for the person.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the date of birth of the person.
     *
     * @return The date of birth of the person.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dob The new date of birth to be set for the person.
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Returns the permanent address of the person.
     *
     * @return The permanent address of the person.
     */
    public String getPermAdd() {
        return permAdd;
    }

    /**
     * Sets the permanent address of the person.
     *
     * @param permAdd The new permanent address to be set for the person.
     */
    public void setPermAdd(String permAdd) {
        this.permAdd = permAdd;
    }

    /**
     * Returns the phone number of the person.
     *
     * @return The phone number of the person.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNum The new phone number to be set for the person.
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

