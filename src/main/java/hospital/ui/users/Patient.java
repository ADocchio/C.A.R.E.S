package hospital.ui.users;

/**
 * Represents a patient, extending the person class with medical-specific details.
 */
public class Patient extends Person {
    private String patientID;
    private String insurancePlan;
    private String emergencyContact;

    /**
     * Constructs a Patient instance with specified personal and medical details.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param dob The date of birth of the person.
     * @param permAdd The permanent address of the person.
     * @param phoneNum The phone number of the person.
     * @param patientID The unique identifier for the patient.
     * @param insurancePlan The insurance plan of the patient.
     * @param emergencyContact The emergency contact information for the patient.
     */
    public Patient(String firstName, String lastName, String dob, String permAdd, int phoneNum,
                   String patientID, String insurancePlan, String emergencyContact) {
        super(firstName, lastName, dob, permAdd, phoneNum);
        this.patientID = patientID;
        this.insurancePlan = insurancePlan;
        this.emergencyContact = emergencyContact;
    }

    /**
     * Constructor that accepts a Person object and additional Patient-specific data.
     *
     * @param person          The Person object from which to inherit properties.
     * @param patientID       The unique identifier for the patient.
     * @param insurancePlan   The insurance plan of the patient.
     * @param emergencyContact The emergency contact information for the patient.
     */
    public Patient(Person person, String patientID, String insurancePlan, String emergencyContact) {
        super(person.getFirstName(), person.getLastName(), person.getDob(), person.getPermAdd(), person.getPhoneNum());
        this.patientID = patientID;
        this.insurancePlan = insurancePlan;
        this.emergencyContact = emergencyContact;
    }

    /**
     * Gets the patient's ID.
     *
     * @return A string representing the patient's ID.
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     * Sets the patient's ID.
     *
     * @param patientID A string to set as the patient's ID.
     */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    /**
     * Gets the patient's insurance plan.
     *
     * @return A string representing the patient's insurance plan.
     */
    public String getInsurancePlan() {
        return insurancePlan;
    }

    /**
     * Sets the patient's insurance plan.
     *
     * @param insurancePlan A string to set as the patient's insurance plan.
     */
    public void setInsurancePlan(String insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    /**
     * Gets the patient's emergency contact information.
     *
     * @return A string representing the patient's emergency contact information.
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * Sets the patient's emergency contact information.
     *
     * @param emergencyContact A string to set as the patient's emergency contact information.
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
}


