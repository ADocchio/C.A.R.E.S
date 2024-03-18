package hospital.ui.users;

/**
 * Represents a staff member, extending the Person class with login credentials.
 */
public class Staff extends Person {
    private String username;
    private String password;

    /**
     * Constructs a new Staff instance with the specified personal details and login credentials.
     *
     * @param firstName The first name of the staff member.
     * @param lastName The last name of the staff member.
     * @param dob The date of birth of the staff member.
     * @param permAdd The permanent address of the staff member.
     * @param phoneNum The phone number of the staff member.
     * @param username The username for the staff member's login credentials.
     * @param password The password for the staff member's login credentials.
     */
    public Staff(String firstName, String lastName, String dob, String permAdd, int phoneNum,
                 String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum);
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of the staff member.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the staff member.
     *
     * @param username The new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the staff member.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the staff member. In a real-world application, this password should be encrypted.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

