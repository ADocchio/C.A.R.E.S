package hospital.ui.users.staff;

import hospital.ui.Main;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;

import java.io.Serializable;

/**
 * Represents an emergency room staff member, specializing the Staff class for emergency room operations.
 */
public class EmergencyRoomStaff extends Staff implements Serializable {

    /**
     * Constructs a new EmergencyRoomStaff instance with the specified details.
     *
     * @param firstName The first name of the emergency room staff member.
     * @param lastName The last name of the emergency room staff member.
     * @param dob The date of birth of the emergency room staff member.
     * @param permAdd The permanent address of the emergency room staff member.
     * @param phoneNum The phone number of the emergency room staff member.
     * @param username The username for the emergency room staff member's login credentials.
     * @param password The password for the emergency room staff member's login credentials.
     */
    public EmergencyRoomStaff(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                              String username, String password) {
        super(firstName, lastName, dob, permAdd, phoneNum, username, password);
    }

    // The class can be extended with methods specific to emergency room operations as needed
    public void createPatient(String lastName, String firstName, String dob, String permAdd, String phoneNum, String insurancePlan, String emergencyContact){
        Patient newPatient = new Patient(new Person(lastName, firstName, dob, permAdd, phoneNum), insurancePlan, emergencyContact);
        String key = newPatient.getPatientID();

        System.out.println(key);
        System.out.println(Main.database.getPatientTable().containsKey(key));
        //see if patient already exists
        if(!Main.database.getPatientTable().containsKey(key)){
            Main.database.getPatientTable().put(key, newPatient);
        }else{
            //Warning!
        }
    }
}

