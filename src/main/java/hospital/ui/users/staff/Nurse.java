package hospital.ui.users.staff;

/**
 * Represents a nurse, specializing the EmergencyRoomStaff class for nursing operations.
 */
public class Nurse extends EmergencyRoomStaff {

    /**
     * Constructs a new Nurse instance with the specified details.
     *
     * @param firstName The first name of the nurse.
     * @param lastName The last name of the nurse.
     * @param dob The date of birth of the nurse.
     * @param permAdd The permanent address of the nurse.
     * @param phoneNum The phone number of the nurse.
     * @param username The username for the nurse's login credentials.
     * @param password The password for the nurse's login credentials.
     */
    public Nurse(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                 String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum, username, password);
    }

    // Additional nurse-specific methods can be defined here
}


