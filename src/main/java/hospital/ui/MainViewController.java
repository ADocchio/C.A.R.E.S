package hospital.ui;
import hospital.ui.labs.Lab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class MainViewController {

    public static String passedRole = "";

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

        //(TEST VERSION ONLY)
        switch (passedRole) {
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
//        firstName.setText();
//        lastName.setText();
//        address.setText();
//        cellPhone.setText();
//        birthday.setText();
//        insurance.setText();
//        emergencyCell.setText();
//
//        height.setText();
//        weight.setText();
//        bp.setText();
//        heartRate.setText();
//        spo2.setText();
//        bodyTemp.setText();
//        bmi.setText();
//
//        redBloodResult.setText();
//        whiteBloodResult.setText();
//        liverResult.setText();
//        renalResult.setText();
//        electrolyteResult.setText();
//        xrayResult.setText();
//        ctResult.setText();
//        mriResult.setText();
//        urineResult.setText();
//        stoolResult.setText();
    }

    /**Takes user input on labs to be run, runs the corresponding labs, then resets run labs view
     * @param event, click of the "Run Labs" button
     */
    public void runLabs(ActionEvent event) {
        CheckBox[] labTests = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};
        Button[] labResults = {redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult};

        for(int i = 0; i < 10; i++){
            if (labTests[i].isSelected()){

                if(Main.aPanel.runLab(i) == Lab.LabResult.Normal){
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

        for(int i = 0; i < 5; i++){
            if (diagnoses[i].isSelected()){//make corresponding scripts available
                for(CheckBox script: scripts[i]){
                    script.setDisable(false);
                }

            }else {//make corresponding scripts unavailable
                for(CheckBox script: scripts[i]){
                    script.setDisable(true);
                    script.setSelected(false);
                }
            }
        }
    }


    public void admitButton (ActionEvent event) {

    }

    /** Handles the ability to edit patient information by clicking on information textfeilds,
     * Makes sure type is correct and updates information of patient currently loaded into view
     */
    private void setupTextFieldHandlers() {

        // Handle losing focus
        firstName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                String lastValidValue = null;

                if (isNumeric(firstName.getText())) {
                    lastValidValue = firstName.getText();
                    //update value in database
                } else {
                    firstName.setText(lastValidValue);
                }
            }
        });

        lastName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                String lastValidValue = null;

                if (isNumeric(lastName.getText())) {
                    lastValidValue = lastName.getText();
                    //update value in database
                } else {
                    lastName.setText(lastValidValue);
                }
            }
        });

        //...........


    }

    // Utility method to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
