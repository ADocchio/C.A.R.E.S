package hospital.ui.users;

/**
 * Represents a patient who has been admitted and later discharged, extending the SeenPatient class with discharge details.
 */
public class AdmittedPatient extends SeenPatient {
    private String dateAdmit;
    private String dischargeInstruction;

    /**
     * Constructs an AdmittedPatient instance with admission and discharge details.
     * Inherits all attributes from SeenPatient and, by extension, Patient and Person classes.
     *
     * @param firstName            The first name of the patient.
     * @param lastName             The last name of the patient.
     * @param dob                  The date of birth of the patient.
     * @param permAdd              The permanent address of the patient.
     * @param phoneNum             The phone number of the patient.
     * @param patientID            The unique identifier for the patient.
     * @param insurancePlan        The insurance plan of the patient.
     * @param emergencyContact     The emergency contact information for the patient.
     * @param timeIn               The time the patient checked in.
     * @param isAdmitted           Whether the patient is currently admitted.
     * @param discharged           Whether the patient has been discharged.
     * @param height               The height of the patient in meters.
     * @param weight               The weight of the patient in kilograms.
     * @param bloodPressure        The blood pressure of the patient.
     * @param heartRate            The heart rate of the patient.
     * @param oxyLevel             The oxygen level of the patient.
     * @param bodyTemp             The body temperature of the patient in Celsius.
     * @param bodyMassIndex        The body mass index of the patient.
     * @param diagnosis            The diagnosis of the patient.
     * @param prescriptions        The prescriptions given to the patient.
     * @param lab                  The lab tests conducted on the patient.
     * @param bill                 The bill generated for the patient's treatment.
     * @param timeOut              The time the patient checked out.
     * @param dateAdmit            The date the patient was admitted.
     * @param dischargeInstruction The instructions provided upon discharge.
     */
    public AdmittedPatient(String firstName, String lastName, String dob, String permAdd, int phoneNum,
                           String patientID, String insurancePlan, String emergencyContact, String timeIn,
                           boolean isAdmitted, boolean discharged, double height, double weight,
                           String bloodPressure, double heartRate, double oxyLevel, double bodyTemp,
                           int bodyMassIndex, String diagnosis, Prescription[] prescriptions, Lab lab,
                           Bill bill, String timeOut, String dateAdmit, String dischargeInstruction) {
        super(firstName, lastName, dob, permAdd, phoneNum, patientID, insurancePlan, emergencyContact,
                timeIn, isAdmitted, discharged, height, weight, bloodPressure, heartRate, oxyLevel,
                bodyTemp, bodyMassIndex, diagnosis, prescriptions, lab, bill, timeOut);
        this.dateAdmit = dateAdmit;
        this.dischargeInstruction = dischargeInstruction;
    }

    /**
     * Constructor that accepts a SeenPatient object and additional AdmittedPatient-specific data.
     *
     * @param seenPatient         The SeenPatient object from which to inherit properties.
     * @param dateAdmit           The date the patient was admitted.
     * @param dischargeInstruction Instructions provided upon discharge.
     */
    public AdmittedPatient(SeenPatient seenPatient, String dateAdmit, String dischargeInstruction) {
        super(seenPatient, seenPatient.getTimeIn(), seenPatient.getTimeOut(), seenPatient.isAdmitted(), seenPatient.isDischarged());
        this.dateAdmit = dateAdmit;
        this.dischargeInstruction = dischargeInstruction;
    }

    /**
     * Gets the date of admission for the patient.
     *
     * @return The date of admission.
     */
    public String getDateAdmit() {
        return dateAdmit;
    }

    /**
     * Sets the date of admission for the patient.
     *
     * @param dateAdmit The date of admission to set.
     */
    public void setDateAdmit(String dateAdmit) {
        this.dateAdmit = dateAdmit;
    }

    /**
     * Gets the discharge instructions for the patient.
     *
     * @return The discharge instructions.
     */
    public String getDischargeInstruction() {
        return dischargeInstruction;
    }

    /**
     * Sets the discharge instructions for the patient.
     *
     * @param dischargeInstruction The discharge instructions to set.
     */
    public void setDischargeInstruction(String dischargeInstruction) {
        this.dischargeInstruction = dischargeInstruction;
    }
}

