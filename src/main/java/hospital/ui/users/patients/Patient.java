package hospital.ui.users.patients;

import hospital.ui.diagnose.Diagnosis;
import hospital.ui.labs.LabPanel;
import hospital.ui.users.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Patient extends Person {
    private String patientID;
    private String insurancePlan;
    private String emergencyContact;

    private LocalDate  admittedDate;
    private boolean isAdmitted;
    private boolean isDischarged;
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

    private LocalDate  dischargeDate;
    private String dischargeInstruction;

    public Patient(Person person){
        super(person.getFirstName(), person.getLastName(), person.getDob(), person.getPermAdd(), person.getPhoneNum());
        this.patientID = person.getFirstName() + person.getLastName() + person.getDob();
        this.insurancePlan = "";
        this.emergencyContact = "";

        this.admittedDate = LocalDate.from(LocalDateTime.now());
        this.isAdmitted = false;
        this.isDischarged = false;
        this.height = -1;
        this.weight = -1;
        this.bloodPressure = "";
        this.heartRate = -1;
        this.oxyLevel = -1;
        this.bodyTemp = -1;
        this.bodyMassIndex = -1;
        this.diagnosis = new Diagnosis();
        this.labPanel = new LabPanel();
        this.bill = new Bill();
        this.dischargeInstruction = "";

        this.dischargeDate = LocalDate.from(LocalDateTime.now());
        this.dischargeInstruction = dischargeInstruction;
    }

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
     * @param admittedDate               The time the patient checked in.
     * @param isAdmitted           Whether the patient is currently admitted.
     * @param isDischarged           Whether the patient has been discharged.
     * @param height               The height of the patient in meters.
     * @param weight               The weight of the patient in kilograms.
     * @param bloodPressure        The blood pressure of the patient.
     * @param heartRate            The heart rate of the patient.
     * @param oxyLevel             The oxygen level of the patient.
     * @param bodyTemp             The body temperature of the patient in Celsius.
     * @param bodyMassIndex        The body mass index of the patient.
     * @param diagnosis            The diagnosis of the patient.
     * @param labPanel                  The lab tests conducted on the patient.
     * @param bill                 The bill generated for the patient's treatment.
     * @param dischargeDate              The time the patient checked out.
     * @param dischargeInstruction The instructions provided upon discharge.
     */
    public Patient(String firstName, String lastName, String dob, String permAdd, String phoneNum,
                           String patientID, String insurancePlan, String emergencyContact, LocalDate admittedDate,
                           boolean isAdmitted, boolean isDischarged, double height, double weight,
                           String bloodPressure, double heartRate, double oxyLevel, double bodyTemp,
                           int bodyMassIndex, Diagnosis diagnosis, LabPanel labPanel,
                           Bill bill, LocalDate dischargeDate, String dischargeInstruction) {
        super(firstName, lastName, dob, permAdd, phoneNum);
        this.patientID = patientID;
        this.insurancePlan = insurancePlan;
        this.emergencyContact = emergencyContact;

        this.admittedDate = admittedDate;
        this.isAdmitted = isAdmitted;
        this.isDischarged = isDischarged;
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

        this.dischargeDate = dischargeDate;
        this.dischargeInstruction = dischargeInstruction;
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

    /**
     * Gets the time the patient checked in.
     *
     * @return The check-in time as a String.
     */
    public LocalDate getAdmittedDate() {
        return admittedDate;
    }

    /**
     * Sets the time the patient checked in.
     *
     * @param admittedDate The check-in time to set.
     */
    public void setAdmittedDate(LocalDate admittedDate) {
        this.admittedDate = admittedDate;
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
        return isDischarged;
    }

    /**
     * Sets the patient's discharged status.
     *
     * @param isDischarged The discharged status to set.
     */
    public void setDischarged(boolean isDischarged) {
        this.isDischarged = isDischarged;
    }

    /**
     * Gets the height of the patient.
     *
     * @return The height in meters.
     */
    public String getHeight() {
        return doubleToStringOrEmpty(height);
    }

    /**
     * Sets the height of the patient.
     *
     * @param height The height in meters as a string to set.
     */
    public void setHeight(String height) {
        this.height = parseDoubleOrDefault(height);
    }

    /**
     * Gets the weight of the patient.
     *
     * @return The weight in kilograms.
     */
    public String getWeight() {
        return doubleToStringOrEmpty(weight);
    }

    /**
     * Sets the weight of the patient.
     *
     * @param weight The weight in kilograms as a string to set.
     */
    public void setWeight(String weight) {
        this.weight = parseDoubleOrDefault(weight);
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
    public String getHeartRate() {
        return doubleToStringOrEmpty(heartRate);
    }

    /**
     * Sets the heart rate of the patient.
     *
     * @param heartRate The heart rate in beats per minute as a string to set.
     */
    public void setHeartRate(String heartRate) {
        this.heartRate = parseDoubleOrDefault(heartRate);
    }

    /**
     * Gets the oxygen level of the patient.
     *
     * @return The oxygen level as a percentage.
     */
    public String getOxyLevel() {
        return doubleToStringOrEmpty(oxyLevel);
    }

    /**
     * Sets the oxygen level of the patient.
     *
     * @param oxyLevel The oxygen level as a percentage as a string to set.
     */
    public void setOxyLevel(String oxyLevel) {
        this.oxyLevel = parseDoubleOrDefault(oxyLevel);
    }

    /**
     * Gets the body temperature of the patient.
     *
     * @return The body temperature in Celsius.
     */
    public String getBodyTemp() {
        return doubleToStringOrEmpty(bodyTemp);
    }

    /**
     * Sets the body temperature of the patient.
     *
     * @param bodyTemp The body temperature in Celsius as a string to set.
     */
    public void setBodyTemp(String bodyTemp) {
        this.bodyTemp = parseDoubleOrDefault(bodyTemp);
    }

    /**
     * Gets the Body Mass Index (BMI) of the patient.
     *
     * @return The BMI as an integer.
     */
    public String getBodyMassIndex() {
        return intToStringOrEmpty(bodyMassIndex);
    }

    /**
     * Sets the Body Mass Index (BMI) of the patient.
     *
     * @param bodyMassIndex The BMI as a string to set.
     */
    public void setBodyMassIndex(String bodyMassIndex) {
        this.bodyMassIndex = parseIntOrDefault(bodyMassIndex);
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
     * @param labPanel The Lab object to set.
     */
    public void setLab(LabPanel labPanel) {
        this.labPanel = labPanel;
    }

    /**
     * Gets the bill for the patient's treatment.
     *
     * @return The bill as a Bill object.
     */
    public String getBill() {
        return bill.toBill(this);
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
    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    /**
     * Sets the time the patient checked out.
     *
     * @param dischargeDate The check-out time to set.
     */
    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
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

    public Period getStay(){
        return (Period.between(getAdmittedDate(), getDischargeDate()));
    }

    // Utility methods for conversion and default values...

    private double parseDoubleOrDefault(String str) {
        if (str == null || str.isEmpty()) {
            return -1; // Return -1 if string is empty or null
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return -1; // Return -1 if parsing fails
        }
    }

    private int parseIntOrDefault(String str) {
        if (str == null || str.isEmpty()) {
            return -1; // Return -1 if string is empty or null
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1; // Return -1 if parsing fails
        }
    }

    private String doubleToStringOrEmpty(double value) {
        return value == -1 ? "" : Double.toString(value);
    }

    private String intToStringOrEmpty(int value) {
        return value == -1 ? "" : Integer.toString(value);
    }
}
