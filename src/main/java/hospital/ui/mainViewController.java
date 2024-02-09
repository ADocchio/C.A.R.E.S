package hospital.ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

import java.io.IOException;
import java.time.chrono.ThaiBuddhistEra;

public class mainViewController {

    //panes
    @FXML
    private TextField weightForm;
    @FXML
    private TitledPane basicInfoPane;
    @FXML
    private TitledPane medicalInfoPane;
    @FXML
    private TitledPane labTestPane;
    @FXML
    private TitledPane labResultsPane;
    @FXML
    private TitledPane diagnosisPane;
    @FXML
    private TitledPane dischargePane;

    //user information
    @FXML
    private Label role;
    @FXML
    private Label userName;

    //patient info
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private TextField cellPhone;
    @FXML
    private TextField birthday;
    @FXML
    private TextField insurance;
    @FXML
    private TextField emergencyCell;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextField bp;
    @FXML
    private TextField heartRate;
    @FXML
    private TextField spo2;
    @FXML
    private TextField bodyTemp;
    @FXML
    private TextField bmi;

    //lab tests
    @FXML
    private CheckBox redBloodLab;
    @FXML
    private CheckBox whiteBloodLab;
    @FXML
    private CheckBox liverLab;
    @FXML
    private CheckBox renalLab;
    @FXML
    private CheckBox electrolyteLab;
    @FXML
    private CheckBox xrayLab;
    @FXML
    private CheckBox ctLab;
    @FXML
    private CheckBox mriLab;
    @FXML
    private CheckBox urineLab;
    @FXML
    private CheckBox stoolLab;

    //lab results
    @FXML
    private Label redBloodResult;
    @FXML
    private Label whiteBloodResult;
    @FXML
    private Label liverResult;
    @FXML
    private Label renalResult;
    @FXML
    private Label electrolyteResult;
    @FXML
    private Label xrayResult;
    @FXML
    private Label ctResult;
    @FXML
    private Label mriResult;
    @FXML
    private Label urineResult;
    @FXML
    private Label stoolResult;


    public void initialize() {
        //setup pane functions
        basicInfoPane.setCollapsible(false);
        medicalInfoPane.setCollapsible(false);
        labTestPane.setCollapsible(false);
        labResultsPane.setCollapsible(false);
        diagnosisPane.setCollapsible(false);
        dischargePane.setCollapsible(false);
        setNurseView();

        //update name fields
        userName.setText("");

//        weightForm.setText(String.valueOf(Main.person.getWeight()));
//        setupTextFieldHandlers();
    }

    private void setDeskStaffView() {
        role.setText("Front Desk Staff");
        //set permissions
        medicalInfoPane.setVisible(false);
        labTestPane.setVisible(false);
        labResultsPane.setVisible(false);
        diagnosisPane.setVisible(false);
        dischargePane.setVisible(false);

    }

    private void setNurseView() {
        role.setText("Nurse");
        //set permissions
        diagnosisPane.setDisable(true);


    }

    private void setDoctorView() {
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
