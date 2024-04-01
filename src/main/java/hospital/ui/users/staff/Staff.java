package hospital.ui.users.staff;

import hospital.ui.Main;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;

import java.io.Serializable;

/**
 * Represents a staff member by extending the {@link Person} class with additional login credentials.
 * This class forms the basis for representing all staff members within the system,
 */
public class Staff extends Person implements Serializable {

    private String username;
    private String password;

    /**
     * Constructs a new {@code Staff} instance with specified personal details and login credentials.
     * @param firstName The first name of the staff member.
     * @param lastName  The last name of the staff member.
     * @param dob       The date of birth of the staff member.
     * @param permAdd   The permanent address of the staff member.
     * @param phoneNum  The phone number of the staff member.
     * @param username  The username for the staff member's login credentials.
     * @param password  The password for the staff member's login credentials.
     */
    public Staff(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                 String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum);
        this.username = username;
        this.password = password;
    }

    /**
     * Searches for a patient based on their last name, first name, and date of birth.
     * This method constructs a key from the provided parameters and attempts to retrieve
     * the corresponding patient from the system's database.
     *
     * @param lastName  The last name of the patient.
     * @param firstName The first name of the patient.
     * @param birthday  The date of birth of the patient.
     * @return The {@link Patient} object if found, otherwise {@code null}.
     */
    public Patient searchPatient(String lastName, String firstName, String birthday) {
        String key = lastName + firstName + birthday;
        System.out.println(key);
        return Main.database.getPatientTable().getOrDefault(key, null);
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
     * Sets the username of the staff member. This could be used for updating the staff member's login credentials.
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
     * Sets the password of the staff member. It's recommended to handle the password securely, potentially
     * using encryption, before setting it here to ensure the security of staff members' credentials.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

