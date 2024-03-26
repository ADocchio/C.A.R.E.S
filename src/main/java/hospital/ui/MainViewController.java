package hospital.ui;
import hospital.ui.diagnose.Condition;
import hospital.ui.diagnose.Prescription;
import hospital.ui.labs.Lab;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.users.patients.PatientUpdater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;

public class MainViewController {

    public static String passedRole = "";
    private Patient currentPatient = Main.getCurrentPatient();

    //panes
    @FXML
    private TitledPane basicInfoPane, medicalInfoPane, labTestPane, labResultsPane, diagnosisPane, dischargePane;

    //panes
    @FXML
    private Button admitButton, dischargeButton;

    //user information
    @FXML
    private Label role, userName;

    //patient info
    @FXML
    private TextField firstName, lastName, address, cellPhone, birthday, insurance, emergencyCell, height, weight, bp, heartRate, spo2, bodyTemp, bmi;

    @FXML
    private TextArea instructionsField, billField;

    //lab tests
    @FXML
    private CheckBox redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab;

    //lab results
    @FXML
    private Button redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult;

    //Scripts
    @FXML
    private CheckBox highBloodScript1, highBloodScript2, highBloodScript3, highCholesterolScript1, highCholesterolScript2, highCholesterolScript3, kidneyScript1, kidneyScript2, kidneyScript3, liverScript1, liverScript2, liverScript3, boneScript1, boneScript2, boneScript3;

    //Diagnosis
    @FXML
    private CheckBox highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus;

    /**Called on loading of the main-view scene
     *
     */
    public void initialize() {
        TitledPane[] panes = {basicInfoPane, medicalInfoPane, labTestPane, labResultsPane, diagnosisPane, dischargePane};
        for(TitledPane pane: panes){
            pane.setCollapsible(false);
        }

        loadPatient();

        //(TEST VERSION ONLY)
        switch (passedRole) {
            case "Billing" -> setBillingStaffView();
            case "Staff" -> setDeskStaffView();
            case "Nurse" -> setNurseView();
            case "Doctor" -> setDoctorView();
        }

        //update user's name(TODO)


        }

    /** Logs out the current user and brings them back to login page
     *
     * @param event, Clicking "log out" button
     * @throws IOException, if login.fxml is unavailable or has errors
     */
    public void logOut(ActionEvent event) throws IOException {
        InterfaceLoad.changeScene("login.fxml", 400, 600, "C.A.R.E.S Login");
    }

    /** Sets the view and permissions for the billing staff dashboard
     *
     */
    private void setBillingStaffView() {
        role.setText("Billing Staff");
        admitButton.setVisible(false);
        billField.setEditable(true);
        billField.setVisible(true);
        billField.setText(currentPatient.getBill());




        //set permissions
        basicInfoPane.setVisible(false);
        medicalInfoPane.setVisible(false);
        labTestPane.setVisible(false);
        labResultsPane.setVisible(false);
        diagnosisPane.setVisible(false);
        dischargePane.setVisible(false);

    }

    /** Sets the view and permissions for the staff dashboard
     *
     */
    private void setDeskStaffView() {
        role.setText("Front Desk Staff");
        admitButton.setText("Check In");

        //set permissions
        medicalInfoPane.setVisible(false);
        labTestPane.setVisible(false);
        labResultsPane.setVisible(false);
        diagnosisPane.setVisible(false);
        dischargePane.setVisible(false);

    }

    /** Sets the view and permissions for the nurse dashboard
     *
     */
    private void setNurseView() {
        admitButton.setText("Admit Patient");
        dischargeButton.setText("Start Discharge");
        role.setText("Nurse");

        //set permissions
        diagnosisPane.setDisable(true);



    }

    /** Sets the view and permissions for the doctor dashboard
     *
     */
    private void setDoctorView() {
        admitButton.setText("Admit Patient");
        dischargeButton.setText("Discharge");
        role.setText("Doctor");

        //set permissions

    }

    /** Loads a patient into the dashboard after being searched
     *
     */
    private void loadPatient(){
        TextInputControl[] stringFields = {firstName, lastName, address, cellPhone, birthday, insurance, emergencyCell, bp, height, weight, heartRate, spo2, bodyTemp, bmi, instructionsField};

        //Setup patient information in UI
        ArrayList<Function<Patient, String>> methods = new ArrayList<>();
        methods.add(Patient::getFirstName);
        methods.add(Patient::getLastName);
        methods.add(Patient::getPermAdd);
        methods.add(Patient::getPhoneNum);
        methods.add(Patient::getDob);
        methods.add(Patient::getInsurancePlan);
        methods.add(Patient::getEmergencyContact);
        methods.add(Patient::getBloodPressure);
        methods.add(Patient::getHeight);
        methods.add(Patient::getWeight);
        methods.add(Patient::getHeartRate);
        methods.add(Patient::getOxyLevel);
        methods.add(Patient::getBodyTemp);
        methods.add(Patient::getBodyMassIndex);
        methods.add(Patient::getDischargeInstruction);

        //load patient information
        for (int i = 0; i < stringFields.length; i++) {
            stringFields[i].setText(methods.get(i).apply(currentPatient));
        }

        //load patient labs
        loadLabs(new ActionEvent());
        loadValidScripts(new ActionEvent());

        //Allow for updating of patient information
        addListenerToTextField(stringFields[0],currentPatient, Patient::setFirstName);
        addListenerToTextField(stringFields[1],currentPatient, Patient::setLastName);
        addListenerToTextField(stringFields[2],currentPatient, Patient::setPermAdd);
        addListenerToTextField(stringFields[3],currentPatient, Patient::setPhoneNum);
        addListenerToTextField(stringFields[4],currentPatient, Patient::setDob);
        addListenerToTextField(stringFields[5],currentPatient, Patient::setInsurancePlan);
        addListenerToTextField(stringFields[6],currentPatient, Patient::setEmergencyContact);
        addListenerToTextField(stringFields[7],currentPatient, Patient::setBloodPressure);
        addListenerToTextField(stringFields[8],currentPatient, Patient::setHeight);
        addListenerToTextField(stringFields[9],currentPatient, Patient::setWeight);
        addListenerToTextField(stringFields[10],currentPatient, Patient::setHeartRate);
        addListenerToTextField(stringFields[11],currentPatient, Patient::setOxyLevel);
        addListenerToTextField(stringFields[12],currentPatient, Patient::setBodyTemp);
        addListenerToTextField(stringFields[13],currentPatient, Patient::setDischargeInstruction);



    }

    public void loadLabs(ActionEvent event) {
        CheckBox[] labTests = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};
        Button[] labResults = {redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult};

        for(int i = 0; i < 10; i++){
            if(Objects.equals(currentPatient.getLabPanel().getCurrentResults()[i], Lab.LabResult.Normal.name())){
                    labResults[i].getStyleClass().clear();
                    labResults[i].getStyleClass().add("lab-result-p");
                    labResults[i].setText(Lab.LabResult.Normal.toString());

            }else if(Objects.equals(currentPatient.getLabPanel().getCurrentResults()[i], Lab.LabResult.Abnormal.name())) {
                    labResults[i].getStyleClass().clear();
                    labResults[i].getStyleClass().add("lab-result-n");
                    labResults[i].setText(Lab.LabResult.Abnormal.toString());
            }else{
                labResults[i].getStyleClass().clear();
                labResults[i].getStyleClass().add("lab-result");
            }
        }

    }

    /**Takes user input on labs to be run, runs the corresponding labs, then resets run labs view
     * @param event, click of the "Run Labs" button
     */
    public void runLabs(ActionEvent event) {
        CheckBox[] labTests = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};
        Button[] labResults = {redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult};

        for(int i = 0; i < 10; i++){
            if (labTests[i].isSelected()){

                if(currentPatient.getLabPanel().runLab(i) == Lab.LabResult.Normal){
                    labResults[i].getStyleClass().clear();
                    labResults[i].getStyleClass().add("lab-result-p");
                    labResults[i].setText(Lab.LabResult.Normal.toString());

                }else {
                    labResults[i].getStyleClass().clear();
                    labResults[i].getStyleClass().add("lab-result-n");
                    labResults[i].setText(Lab.LabResult.Abnormal.toString());
                }

            }else {
                labResults[i].getStyleClass().clear();
                labResults[i].getStyleClass().add("lab-result");

                labResults[i].setText("");
            }

            labTests[i].setSelected(false);
        }

    }

    public void loadValidScripts(ActionEvent event) {
        CheckBox[] bloodScripts = {highBloodScript1, highBloodScript2, highBloodScript3};
        CheckBox[] cholesterolScripts = {highCholesterolScript1, highCholesterolScript2, highCholesterolScript3};
        CheckBox[] kidneyScripts = {kidneyScript1, kidneyScript2, kidneyScript3};
        CheckBox[] liverScripts = {liverScript1, liverScript2, liverScript3};
        CheckBox[] boneScripts = {boneScript1, boneScript2, boneScript3};

        CheckBox[][] scripts = {bloodScripts, cholesterolScripts, kidneyScripts, liverScripts, boneScripts};
        CheckBox[] diagnoses = { highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};

        Condition[] conditions = currentPatient.getDiagnosis().getConditions();

        for(int i = 0; i < 5; i++){
            Prescription[] prescriptions = conditions[i].getValidPrescriptions();

            for(int j = 0; j < 3; j++)
            {
                scripts[i][j].setSelected(prescriptions[j].isPrescribed());
                scripts[i][j].setDisable(!prescriptions[j].isPrescribed());

                if(prescriptions[j].isPrescribed()){
                    diagnoses[i].setSelected(true);
                    diagnoses[i].setDisable(false);
                }
            }

        }
    }

    /**Enables and Disables the ability to prescribe prescriptions based on diagnosis selection
     * @param event, The selection of a diagnosis
     */
    public void updateValidScripts(ActionEvent event) {
        CheckBox[] bloodScripts = {highBloodScript1, highBloodScript2, highBloodScript3};
        CheckBox[] cholesterolScripts = {highCholesterolScript1, highCholesterolScript2, highCholesterolScript3};
        CheckBox[] kidneyScripts = {kidneyScript1, kidneyScript2, kidneyScript3};
        CheckBox[] liverScripts = {liverScript1, liverScript2, liverScript3};
        CheckBox[] boneScripts = {boneScript1, boneScript2, boneScript3};

        CheckBox[][] scripts = {bloodScripts, cholesterolScripts, kidneyScripts, liverScripts, boneScripts};
        CheckBox[] diagnoses = { highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};

        Condition[] conditions = currentPatient.getDiagnosis().getConditions();

        for(int i = 0; i < 5; i++){
            Prescription[] prescriptions = conditions[i].getValidPrescriptions();
            if (diagnoses[i].isSelected()){//make corresponding scripts available
                for(int j = 0; j < 3; j++)
                {
                    scripts[i][j].setDisable(false);
                }

            }else {//make corresponding scripts unavailable
                for(int j = 0; j < 3; j++)
                {
                    scripts[i][j].setDisable(true);
                    scripts[i][j].setSelected(false);
                    prescriptions[j].setPrescribed(false);
                }
            }
        }
    }

    /**updates prescriptions based on diagnosis selection
     * @param event, The selection of a prescription
     */
    public void updateScripts(ActionEvent event) {
        CheckBox[] bloodScripts = {highBloodScript1, highBloodScript2, highBloodScript3};
        CheckBox[] cholesterolScripts = {highCholesterolScript1, highCholesterolScript2, highCholesterolScript3};
        CheckBox[] kidneyScripts = {kidneyScript1, kidneyScript2, kidneyScript3};
        CheckBox[] liverScripts = {liverScript1, liverScript2, liverScript3};
        CheckBox[] boneScripts = {boneScript1, boneScript2, boneScript3};

        CheckBox[][] scripts = {bloodScripts, cholesterolScripts, kidneyScripts, liverScripts, boneScripts};
        Condition[] conditions = currentPatient.getDiagnosis().getConditions();

        for (int i = 0; i < 5; i++) {
            Prescription[] prescriptions = conditions[i].getValidPrescriptions();
            for(int j = 0; j < 3; j++)
            {
                prescriptions[j].setPrescribed(scripts[i][j].isSelected());
            }
        }
    }


    public void addListenerToTextField(TextInputControl text, Patient patient, PatientUpdater updater) {
        text.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                updater.apply(patient, text.getText());
            }
        });
    }

    public void admitButton (ActionEvent event){
        for (Condition c: currentPatient.getDiagnosis().getConditions()) {
            for (Prescription p: c.getValidPrescriptions()){
                System.out.println(p.isPrescribed());
            }
        }
    }

}
