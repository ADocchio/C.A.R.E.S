package hospital.ui.users.patients;

import hospital.ui.diagnose.Diagnosis;
import hospital.ui.labs.LabPanel;
import hospital.ui.users.Person;
import hospital.ui.warnings.WarningManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * Represents a patient in the hospital system, extending the {@link Person} class
 * with additional attributes relevant to a patient's care and management.
 */
public class Patient extends Person implements Serializable {
    private String patientID;
    private String insurancePlan;
    private String emergencyContact;

    private LocalDate  admittedDate;
    private boolean isAdmitted;
    private boolean isStartedDischarged;
    private boolean isDischarged;
    private double height;
    private double weight;
    private String bloodPressure;
    private double heartRate;
    private double oxyLevel;
    private double bodyTemp;
    private double bodyMassIndex;
    private Diagnosis diagnosis;
    private LabPanel labPanel;
    private Bill bill;

    private LocalDate  dischargeDate;
    private String dischargeInstruction;

    /**
     * Constructs a new {@code Patient} object by copying basic information from an existing {@code Person} object
     * and initializing patient-specific details such as insurance plan and emergency contact information.
     *
     * @param person           The {@link Person} object containing basic information about the patient.
     * @param insurancePlan    The insurance plan of the patient.
     * @param emergencyContact The emergency contact information for the patient, formatted as 000-000-0000.
     */
    public Patient(Person person, String insurancePlan, String emergencyContact){
        super(person.getFirstName(), person.getLastName(), person.getDob(), person.getPermAdd(), person.getPhoneNum());
        this.patientID = person.getLastName() + person.getFirstName() + person.getDob();
        this.insurancePlan = insurancePlan;
        this.emergencyContact = emergencyContact;

        this.admittedDate = LocalDate.from(LocalDateTime.now());
        this.isAdmitted = false;
        this.isDischarged = false;
        this.isStartedDischarged = false;
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

        this.dischargeDate = LocalDate.from(LocalDateTime.now());
        this.dischargeInstruction = "";
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
        if(emergencyContact.matches("^\\d{3}-\\d{3}-\\d{4}$")){
            this.emergencyContact = emergencyContact;
        } else if (emergencyContact.equals("")) {
            this.emergencyContact = "";
        }else{
            WarningManager.getInstance().showWarningToAll("Invalid Input, 000-000-0000");
        }
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

    public boolean isStartedDischarged() {
        return isDischarged;
    }

    public void setStartedDischarged(boolean isStartedDischarged) {
        this.isStartedDischarged = isStartedDischarged;
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
        double parseHeight = parseDoubleOrDefault(height);
        if(parseHeight <= 96 && parseHeight >= 0){
            this.height = parseHeight;
            setBodyMassIndex();
        }else if(height.equals("")) {
            this.height = -1;
        }else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, Range of 0-96 inches");
        }

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
        double parseWeight = parseDoubleOrDefault(weight);
        if(parseWeight <= 1000 && parseWeight >= 0){
            this.weight = parseWeight;
            setBodyMassIndex();
        }else if(weight.equals("")){
            this.weight = -1;
        }else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, Range of 0-1000 pounds");
        }
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
        if (bloodPressure.matches("^(\\d{1,3})/(\\d{1,3})$")) {
            String[] parts = bloodPressure.split("/");
            int systolic = Integer.parseInt(parts[0]);
            int diastolic = Integer.parseInt(parts[1]);

            // Validate the ranges for systolic (0-200) and diastolic (0-150)
            if (systolic >= 0 && systolic <= 200 && diastolic >= 0 && diastolic <= 150) {
                this.bloodPressure = bloodPressure;
            } else {
                WarningManager.getInstance().showWarningToAll("Blood pressure values out of range. Systolic should be 0-200 and diastolic should be 0-150.");
            }
        }else if(bloodPressure.equals("")) {
            this.bloodPressure = "";
        } else {
            WarningManager.getInstance().showWarningToAll("Invalid blood pressure format. Correct format: 'systolic/diastolic'.");
        }
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
        double parseRate = parseDoubleOrDefault(heartRate);
        if(parseRate <= 200 && parseRate >= 0){
            this.heartRate = parseRate;
        }else if(heartRate.equals("")) {
            this.heartRate = -1;
        }else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, Range of 0-200 BPM");
        }
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
        double parseLvl = parseDoubleOrDefault(oxyLevel);
        if(parseLvl <= 100 && parseLvl >= -1){
            this.oxyLevel = parseLvl;
        }else if(oxyLevel.equals("")) {
            this.oxyLevel = -1;
        }else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, Range of 0-100%");
        }
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
        double parseTemp = parseDoubleOrDefault(bodyTemp);
        if(parseTemp <= 100 && parseTemp >= -1){
            this.bodyTemp = parseTemp;
        }else if(bodyTemp.equals("")) {
            this.bodyTemp = -1;
        }else {
            WarningManager.getInstance().showWarningToAll("Invalid Input, Range of 0-150 F");
        }
    }

    public void setBodyMassIndex() {
        this.bodyMassIndex = Double.parseDouble(String.format("%.2f", 703 * (weight / (height * height))));
    }

    /**
     * Gets the Body Mass Index (BMI) of the patient.
     *
     * @return The BMI as an integer.
     */
    public String getBodyMassIndex() {
        if(height == 0 || weight == 0){
            return doubleToStringOrEmpty(bodyMassIndex);
        }else{
            return "";
        }
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

    public void clearPatient(){
        this.setLastName("");
        this.setFirstName("");
        this.setDob("");
        this.setPermAdd("");
        this.setPhoneNum("");
        this.setEmergencyContact("");
        this.patientID = "";
        this.insurancePlan = "";
        this.emergencyContact = "";

        this.admittedDate = LocalDate.from(LocalDateTime.now());
        this.isAdmitted = false;
        this.isDischarged = false;
        this.isStartedDischarged = false;
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

        this.dischargeDate = LocalDate.from(LocalDateTime.now());
        this.dischargeInstruction = "";
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

    private String doubleToStringOrEmpty(double value) {
        return value == -1 ? "" : Double.toString(value);
    }

    private String intToStringOrEmpty(int value) {
        return value == -1 ? "" : Integer.toString(value);
    }
}
