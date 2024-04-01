package hospital.ui.users.staff;

import java.io.Serializable;


/**
 * Represents a nurse, specializing the {@link EmergencyRoomStaff} class for nursing operations.
 * This class inherits from {@code EmergencyRoomStaff} to provide functionalities and properties
 * specific to nurses working in an emergency room setting.
 */
public class Nurse extends EmergencyRoomStaff implements Serializable {

    /**
     * Constructs a new {@code Nurse} instance with specified personal and professional details.
     * @param firstName The first name of the nurse.
     * @param lastName  The last name of the nurse.
     * @param dob       The date of birth of the nurse.
     * @param permAdd   The permanent address of the nurse.
     * @param phoneNum  The phone number of the nurse.
     * @param username  The username for the nurse's login credentials.
     * @param password  The password for the nurse's login credentials.
     */
    public Nurse(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                 String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum, username, password);
    }
}


