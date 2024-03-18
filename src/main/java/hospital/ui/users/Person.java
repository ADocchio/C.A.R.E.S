package hospital.ui.users;

/**
 * Represents a person with basic personal information.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String dob; // Date of Birth
    private String permAdd; // Permanent Address
    private int phoneNum; // Phone Number

    /**
     * Constructs a new Person with the specified details.
     *
     * @param firstName the first name of the person
     * @param lastName  the last name of the person
     * @param dob       the date of birth of the person
     * @param permAdd   the permanent address of the person
     * @param phoneNum  the phone number of the person
     */
    public Person(String firstName, String lastName, String dob, String permAdd, int phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.permAdd = permAdd;
        this.phoneNum = phoneNum;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", permAdd='" + permAdd + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }

    /**
     * Returns the first name of the person.
     *
     * @return the first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return the last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the date of birth of the person.
     *
     * @return the date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dob the new date of birth
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Returns the permanent address of the person.
     *
     * @return the permanent address
     */
    public String getPermAdd() {
        return permAdd;
    }

    /**
     * Sets the permanent address of the person.
     *
     * @param permAdd the new permanent address
     */
    public void setPermAdd(String permAdd) {
        this.permAdd = permAdd;
    }

    /**
     * Returns the phone number of the person.
     *
     * @return the phone number
     */
    public int getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNum the new phone number
     */
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}

