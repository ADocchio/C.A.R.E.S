package hospital.ui.users.staff;

import hospital.ui.Main;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.warnings.WarningManager;

import java.io.Serializable;

/**
 * Represents an emergency room staff member, specializing the {@link Staff} class for emergency room operations.
 * This class extends the generic staff functionalities to cater specifically to the needs and operations
 * encountered by staff members
 */
public class EmergencyRoomStaff extends Staff implements Serializable {

    /**
     * Constructs a new {@code EmergencyRoomStaff} instance with the specified details.
     * This constructor initializes an emergency room staff member with all the necessary information
     * required for their identification and access within the hospital's system.
     *
     * @param firstName   The first name of the emergency room staff member.
     * @param lastName    The last name of the emergency room staff member.
     * @param dob         The date of birth of the emergency room staff member.
     * @param permAdd     The permanent address of the emergency room staff member.
     * @param phoneNum    The phone number of the emergency room staff member.
     * @param username    The username for the emergency room staff member's login credentials.
     * @param password    The password for the emergency room staff member's login credentials.
     */
    public EmergencyRoomStaff(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                              String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum, username, password);
    }

    /**
     * Creates a new patient record and adds it to the hospital's database.
     * This method constructs a {@link Patient} instance with the provided information
     * and attempts to add it to the database. If a patient with the same identifier already exists,
     * a warning is issued using a {@link WarningManager}.
     *
     * @param lastName         The last name of the patient.
     * @param firstName        The first name of the patient.
     * @param dob              The date of birth of the patient.
     * @param permAdd          The permanent address of the patient.
     * @param phoneNum         The phone number of the patient.
     * @param insurancePlan    The insurance plan of the patient.
     * @param emergencyContact The emergency contact information for the patient.
     */
    public void createPatient(String lastName, String firstName, String dob, String permAdd, String phoneNum, String insurancePlan, String emergencyContact) {
        Patient newPatient = new Patient(new Person(lastName, firstName, dob, permAdd, phoneNum), insurancePlan, emergencyContact);
        String key = newPatient.getPatientID();

        System.out.println(key);
        System.out.println(Main.database.getPatientTable().containsKey(key));
        // Check if the patient already exists in the database
        if (!Main.database.getPatientTable().containsKey(key)) {
            Main.database.getPatientTable().put(key, newPatient);
        } else {
            WarningManager.getInstance().showWarningToAll("This patient already exists");
        }
    }
}

