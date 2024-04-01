package hospital.ui.users.staff;

import java.io.Serializable;

/**
 * Represents a doctor, further specializing the Nurse class for medical operations.
 */
public class Doctor extends Nurse implements Serializable {

    /**
     * Constructs a new Doctor instance with the specified details.
     *
     * @param firstName The first name of the doctor.
     * @param lastName The last name of the doctor.
     * @param dob The date of birth of the doctor.
     * @param permAdd The permanent address of the doctor.
     * @param phoneNum The phone number of the doctor.
     * @param username The username for the doctor's login credentials.
     * @param password The password for the doctor's login credentials.
     */
    public Doctor(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                  String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum, username, password);
    }

}

