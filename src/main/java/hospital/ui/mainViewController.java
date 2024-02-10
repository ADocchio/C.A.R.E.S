package hospital.ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class mainViewController {

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
    private Label redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult;

    //Scripts
    @FXML
    private CheckBox highBloodScript1, highBloodScript2, highBloodScript3, highCholesterolScript1, highCholesterolScript2, highCholesterolScript3, kidneyScript1, kidneyScript2, kidneyScript3, liverScript1, liverScript2, liverScript3, boneScript1, boneScript2, boneScript3;

    //Diagnosis
    @FXML
    private CheckBox highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus;

    public void initialize() {
        //setup pane functions
        basicInfoPane.setCollapsible(false);
        medicalInfoPane.setCollapsible(false);
        labTestPane.setCollapsible(false);
        labResultsPane.setCollapsible(false);
        diagnosisPane.setCollapsible(false);
        dischargePane.setCollapsible(false);

        switch (passedRole) {
            case "Staff" -> setDeskStaffView();
            case "Nurse" -> setNurseView();
            case "Doctor" -> setDoctorView();
        }

            //update name fields
            //weightForm.setText(String.valueOf(Main.person.getWeight()));
            // setupTextFieldHandlers();
        }

    public void logOut(ActionEvent event) throws IOException {
        interfaceLoad.changeScene("login.fxml", 400, 600);
    }

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

    private void setNurseView() {
        admitButton.setText("Admit Patient");
        dischargeButton.setText("Start Discharge");
        role.setText("Nurse");

        //set permissions
        diagnosisPane.setDisable(true);


    }

    private void setDoctorView() {
        admitButton.setText("Admit Patient");
        dischargeButton.setText("Discharge");
        role.setText("Doctor");

        //set permissions

    }

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

    public void runLabs(ActionEvent event) throws IOException {
        CheckBox[] labTests = {redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab};
        Label[] labResults = {redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult};

        for(int i = 0; i < 10; i++){
            if (labTests[i].isSelected()){
                //call the lab result function
                labResults[i].setText("");
            }

            labTests[i].setSelected(false);
        }

    }

    public void updateValidScripts(ActionEvent event) throws IOException {
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
