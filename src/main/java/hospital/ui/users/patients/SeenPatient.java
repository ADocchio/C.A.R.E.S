package hospital.ui.users.patients;

import hospital.ui.diagnose.Diagnosis;
import hospital.ui.labs.LabPanel;


/**
 * Represents a patient that has been seen by medical staff, extending the Patient class with additional details.
 */
public class SeenPatient extends APatient {
    private String timeIn;
    private boolean isAdmitted;
    private boolean discharged;
    private double height;
    private double weight;
    private String bloodPressure;
    private double heartRate;
    private double oxyLevel;
    private double bodyTemp;
    private int bodyMassIndex;
    private Diagnosis diagnosis;
    private LabPanel labPanel;
    private Bill bill;
    private String timeOut;

    /**
     * Constructs a SeenPatient instance with specific medical details.
     * Inherits patientID, insurancePlan, and emergencyContact from the Patient class.
     *
     * @param firstName        The first name of the patient.
     * @param lastName         The last name of the patient.
     * @param dob              The date of birth of the patient.
     * @param permAdd          The permanent address of the patient.
     * @param phoneNum         The phone number of the patient.
     * @param patientID        The unique identifier for the patient.
     * @param insurancePlan    The insurance plan of the patient.
     * @param emergencyContact The emergency contact information for the patient.
     * @param timeIn           The time the patient checked in.
     * @param isAdmitted       Whether the patient is currently admitted.
     * @param discharged       Whether the patient has been discharged.
     * @param height           The height of the patient in meters.
     * @param weight           The weight of the patient in kilograms.
     * @param bloodPressure    The blood pressure of the patient.
     * @param heartRate        The heart rate of the patient.
     * @param oxyLevel         The oxygen level of the patient.
     * @param bodyTemp         The body temperature of the patient in Celsius.
     * @param bodyMassIndex    The body mass index of the patient.
     * @param diagnosis        The diagnosis of the patient.
     * @param labPanel         The lab tests conducted on the patient.
     * @param bill             The bill generated for the patient's treatment.
     * @param timeOut          The time the patient checked out.
     */
    public SeenPatient(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                       String patientID, String insurancePlan, String emergencyContact, String timeIn,
                       boolean isAdmitted, boolean discharged, double height, double weight,
                       String bloodPressure, double heartRate, double oxyLevel, double bodyTemp,
                       int bodyMassIndex, Diagnosis diagnosis, LabPanel labPanel,
                       Bill bill, String timeOut) {
        super(firstName, lastName, dob, permAdd, phoneNum, patientID, insurancePlan, emergencyContact);
        this.timeIn = timeIn;
        this.isAdmitted = isAdmitted;
        this.discharged = discharged;
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.oxyLevel = oxyLevel;
        this.bodyTemp = bodyTemp;
        this.bodyMassIndex = bodyMassIndex;
        this.diagnosis = diagnosis;
        this.labPanel = labPanel;
        this.bill = bill;
        this.timeOut = timeOut;
    }

    /**
     * Constructor that accepts a Patient object and additional SeenPatient-specific data.
     *
     * @param patient            The Patient object from which to inherit properties.
     * @param timeIn             The time the patient checked in.
     * @param timeOut            The time the patient checked out.
     * @param isAdmitted         Indicates whether the patient is admitted.
     * @param discharged         Indicates whether the patient has been discharged.
     */
    public SeenPatient(APatient patient, String timeIn, String timeOut, boolean isAdmitted, boolean discharged) {
        super(patient, patient.getPatientID(), patient.getInsurancePlan(), patient.getEmergencyContact());
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.isAdmitted = isAdmitted;
        this.discharged = discharged;
    }

    /**
     * Gets the time the patient checked in.
     *
     * @return The check-in time as a String.
     */
    public String getTimeIn() {
        return timeIn;
    }

    /**
     * Sets the time the patient checked in.
     *
     * @param timeIn The check-in time to set.
     */
    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * Checks if the patient is currently admitted.
     *
     * @return True if admitted, false otherwise.
     */
    public boolean isAdmitted() {
        return isAdmitted;
    }

    /**
     * Sets the patient's admitted status.
     *
     * @param admitted The admitted status to set.
     */
    public void setAdmitted(boolean admitted) {
        isAdmitted = admitted;
    }

    /**
     * Checks if the patient has been discharged.
     *
     * @return True if discharged, false otherwise.
     */
    public boolean isDischarged() {
        return discharged;
    }

    /**
     * Sets the patient's discharged status.
     *
     * @param discharged The discharged status to set.
     */
    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    /**
     * Gets the height of the patient.
     *
     * @return The height in meters.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the patient.
     *
     * @param height The height in meters to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the weight of the patient.
     *
     * @return The weight in kilograms.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the patient.
     *
     * @param weight The weight in kilograms to set.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the blood pressure of the patient.
     *
     * @return The blood pressure as a String.
     */
    public String getBloodPressure() {
        return bloodPressure;
    }

    /**
     * Sets the blood pressure of the patient.
     *
     * @param bloodPressure The blood pressure to set.
     */
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    /**
     * Gets the heart rate of the patient.
     *
     * @return The heart rate in beats per minute.
     */
    public double getHeartRate() {
        return heartRate;
    }

    /**
     * Sets the heart rate of the patient.
     *
     * @param heartRate The heart rate in beats per minute to set.
     */
    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * Gets the oxygen level of the patient.
     *
     * @return The oxygen level as a percentage.
     */
    public double getOxyLevel() {
        return oxyLevel;
    }

    /**
     * Sets the oxygen level of the patient.
     *
     * @param oxyLevel The oxygen level as a percentage to set.
     */
    public void setOxyLevel(double oxyLevel) {
        this.oxyLevel = oxyLevel;
    }

    /**
     * Gets the body temperature of the patient.
     *
     * @return The body temperature in Celsius.
     */
    public double getBodyTemp() {
        return bodyTemp;
    }

    /**
     * Sets the body temperature of the patient.
     *
     * @param bodyTemp The body temperature in Celsius to set.
     */
    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    /**
     * Gets the Body Mass Index (BMI) of the patient.
     *
     * @return The BMI as an integer.
     */
    public int getBodyMassIndex() {
        return bodyMassIndex;
    }

    /**
     * Sets the Body Mass Index (BMI) of the patient.
     *
     * @param bodyMassIndex The BMI to set.
     */
    public void setBodyMassIndex(int bodyMassIndex) {
        this.bodyMassIndex = bodyMassIndex;
    }

    /**
     * Gets the diagnosis of the patient.
     *
     * @return The diagnosis as a String.
     */
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets the diagnosis of the patient.
     *
     * @param diagnosis The diagnosis to set.
     */
    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Gets the lab tests for the patient.
     *
     * @return The lab test as a Lab object.
     */
    public LabPanel getLabPanel() {
        return labPanel;
    }

    /**
     * Sets the lab test for the patient.
     *
     * @param lab The Lab object to set.
     */
    public void setLab(LabPanel labPanel) {
        this.labPanel = labPanel;
    }

    /**
     * Gets the bill for the patient's treatment.
     *
     * @return The bill as a Bill object.
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * Sets the bill for the patient's treatment.
     *
     * @param bill The Bill object to set.
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    /**
     * Gets the time the patient checked out.
     *
     * @return The check-out time as a String.
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * Sets the time the patient checked out.
     *
     * @param timeOut The check-out time to set.
     */
    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
}