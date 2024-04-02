package hospital.ui;
import hospital.ui.diagnose.Condition;
import hospital.ui.diagnose.Prescription;
import hospital.ui.labs.Lab;
import hospital.ui.users.Person;
import hospital.ui.users.patients.Patient;
import hospital.ui.users.patients.PatientUpdater;
import hospital.ui.users.staff.*;
import hospital.ui.warnings.WarningListener;
import hospital.ui.warnings.WarningManager;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class MainViewController implements WarningListener {

    public static Patient nullPatient = new Patient(new Person("", "", "", "", ""), "", "");;
    public static Staff passedPosition;
    public static Patient currentPatient = nullPatient;
    private static String currentKey = "";
    private final Map<TextInputControl, ChangeListener<Boolean>> listenerMap = new HashMap<TextInputControl,  ChangeListener<Boolean> >();

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
    private TextField firstName, lastName, address, cellPhone, birthday, insurance, emergencyCell, height, weight, bp, heartRate, spo2, bodyTemp, bmi, searchName, searchDOB;

    @FXML
    private TextArea instructionsField, billField;

    //lab tests
    @FXML
    private CheckBox redBloodLab, whiteBloodLab, liverLab, renalLab, electrolyteLab, xrayLab, ctLab, mriLab, urineLab, stoolLab;

    //lab results
    @FXML
    private Button redBloodResult, whiteBloodResult, liverResult, renalResult, electrolyteResult, xrayResult, ctResult, mriResult, urineResult, stoolResult, patientStatus, search;

    //Scripts
    @FXML
    private CheckBox highBloodScript1, highBloodScript2, highBloodScript3, highCholesterolScript1, highCholesterolScript2, highCholesterolScript3, kidneyScript1, kidneyScript2, kidneyScript3, liverScript1, liverScript2, liverScript3, boneScript1, boneScript2, boneScript3;

    //Diagnosis
    @FXML
    private CheckBox highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus;

    /**
     * Called on loading of the main-view scene
     */
    public void initialize() {
        TitledPane[] panes = {basicInfoPane, medicalInfoPane, labTestPane, labResultsPane, diagnosisPane, dischargePane};
        for (TitledPane pane : panes) {
            pane.setCollapsible(false);
        }

        WarningManager.getInstance().addListener(this);

        if(passedPosition instanceof Doctor){
            setDoctorView();
            role.setText("Doctor");
        } else if (passedPosition instanceof Nurse) {
            setNurseView();
            role.setText("Nurse");
        }else if (passedPosition instanceof EmergencyRoomStaff) {
            setDeskStaffView();
            role.setText("Desk Staff");
        }else if (passedPosition instanceof BillingStaff) {
            setBillingStaffView();
            role.setText("Billing Staff");
        }
        userName.setText(passedPosition.getLastName() + ", " + passedPosition.getFirstName());
    }


    /** Logs out the current user and brings them back to login page
     *
     * @param event, Clicking "log out" button
     * @throws IOException, if login.fxml is unavailable or has errors
     */
    public void logOut(ActionEvent event) throws IOException {
        InterfaceLoad.changeScene("login.fxml", 400, 600, "C.A.R.E.S Login");
        unloadPatient();
    }

    /** Sets the view and permissions for the billing staff dashboard
     *
     */
    private void setBillingStaffView() {
        role.setText("Billing Staff");
        admitButton.setVisible(false);
        billField.setEditable(true);
        billField.setVisible(true);

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
        searchName.setDisable(true);
        searchDOB.setDisable(true);
        search.setDisable(true);


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
        dischargeButton.setDisable(true);
        role.setText("Doctor");

        //set permissions

    }

    /** Loads a patient into the dashboard after being searched
     *
     */
    private void loadPatient(){
        if(currentPatient != null){
            TextInputControl[] stringFields = {firstName, lastName, address, cellPhone, birthday, insurance, emergencyCell, bp, height, weight, heartRate, spo2, bodyTemp, bmi, instructionsField};

            //clear the null patient just in-case values were set
            if(currentPatient == nullPatient){
                currentPatient.clearPatient();
            }

            //look to see if patient is admitted or not
            if(currentPatient.isAdmitted()){
                patientStatus.setText("Patient Status: Admitted");
                admitButton.setDisable(true);
            }else{
                patientStatus.setText("Patient Status: Not Admitted");
                admitButton.setDisable(false);
            }

            //look to see if patient is discharge started or not
            if(currentPatient.isStartedDischarged()) {
                admitButton.setDisable(true);
                if (passedPosition instanceof Nurse && !(passedPosition instanceof Doctor)) {
                    dischargeButton.setDisable(true);
                } else if (passedPosition instanceof Doctor) {
                    dischargeButton.setDisable(false);
                }
            }

            loadFields();

            //load patient labs and scripts and bill
            loadLabs(new ActionEvent());
            loadValidScripts(new ActionEvent());
            billField.setText(currentPatient.getBill());

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
            addListenerToTextField(stringFields[14],currentPatient, Patient::setDischargeInstruction);

        }
    }

    private void loadFields(){
        TextInputControl[] stringFields = {firstName, lastName, address, cellPhone, birthday, insurance, emergencyCell, bp, height, weight, heartRate, spo2, bodyTemp, bmi, instructionsField};

        //Setup patient information in UI
        ArrayList<Function<Patient, String>> methods = new ArrayList<>(Arrays.asList(Patient::getFirstName,Patient::getLastName, Patient::getPermAdd, Patient::getPhoneNum, Patient::getDob, Patient::getInsurancePlan,
                Patient::getEmergencyContact, Patient::getBloodPressure, Patient::getHeight, Patient::getWeight, Patient::getHeartRate, Patient::getOxyLevel, Patient::getBodyTemp, Patient::getBodyMassIndex, Patient::getDischargeInstruction));

        //load patient information
        for (int i = 0; i < stringFields.length; i++) {
            stringFields[i].setText(methods.get(i).apply(currentPatient));
        }
    }

    private void unloadPatient(){
        if(currentPatient != null ){
            TextInputControl[] stringFields = {firstName, lastName, address, cellPhone, birthday, insurance, emergencyCell, bp, height, weight, heartRate, spo2, bodyTemp, bmi, instructionsField};

            //stop updating of patient information
            for (TextInputControl field: stringFields) {
                removeListenerFromTextField(field);
            }

            //if an actually patient is loaded clear them
            if(currentPatient != nullPatient){
                currentPatient = nullPatient;
                loadPatient();
            }

        }
    }

    public void loadLabs(ActionEvent event) {
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
                labResults[i].setText("");
            }
        }

    }

    public void searchPatient(ActionEvent event){

            String name = searchName.getText();
            String dob = searchDOB.getText();

            //preform checks (not null valid format)
        unloadPatient();
        if(name != null && dob != null  ){
            if(name.matches("[A-Za-z'-]+, [A-Za-z'-]+") && dob.matches("\\d{2}/\\d{2}/\\d{4}")){
                String[] names = name.split(",");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].trim();
                }

                unloadPatient(); //unloads null patient (from previous unload)
                Patient result = passedPosition.searchPatient(names[0], names[1], searchDOB.getText());
                if(result != null){
                    currentPatient = result;
                    currentKey = (names[0] + names[1] + dob);
                    loadPatient();
                }else{
                    showWarning("No patient found!");
                }

            }else{
                showWarning("Please enter a valid search (lastname, firstname), (00/00/0000)");
            }

        }

        //Otherwise Warning
    }

    /**Takes user input on labs to be run, runs the corresponding labs, then resets run labs view
     * @param event, click of the "Run Labs" button
     */
    public void runLabs(ActionEvent event) {
        if(currentPatient != null){
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
    }

    public void loadValidScripts(ActionEvent event) {
        if(currentPatient != null) {
            CheckBox[] bloodScripts = {highBloodScript1, highBloodScript2, highBloodScript3};
            CheckBox[] cholesterolScripts = {highCholesterolScript1, highCholesterolScript2, highCholesterolScript3};
            CheckBox[] kidneyScripts = {kidneyScript1, kidneyScript2, kidneyScript3};
            CheckBox[] liverScripts = {liverScript1, liverScript2, liverScript3};
            CheckBox[] boneScripts = {boneScript1, boneScript2, boneScript3};

            CheckBox[][] scripts = {bloodScripts, cholesterolScripts, kidneyScripts, liverScripts, boneScripts};
            CheckBox[] diagnoses = { highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};

            Condition[] conditions = currentPatient.getDiagnosis().getConditions();

            for(int i = 0; i < 5; i++){
                //get the 5 possible diagnoses
                Prescription[] prescriptions = conditions[i].getValidPrescriptions();

                //look to see if any of the child scripts are selected, if so select diagnose otherwise do not.
                if(currentPatient.getDiagnosis().getIsDiagnosed()[i]){
                    diagnoses[i].setSelected(true);
                    for(int j = 0; j < 3; j++)
                    {
                        scripts[i][j].setSelected(prescriptions[j].isPrescribed());
                        scripts[i][j].setDisable(false);
                    }
                }else {
                    diagnoses[i].setSelected(false);
                    for (int j = 0; j < 3; j++) {
                        scripts[i][j].setSelected(false);
                        scripts[i][j].setDisable(true);
                    }
                }
            }
        }
    }

    /**Enables and Disables the ability to prescribe prescriptions based on diagnosis selection
     * @param event, The selection of a diagnosis
     */
    public void updateValidScripts(ActionEvent event) {
        if(currentPatient != null) {
            CheckBox[] bloodScripts = {highBloodScript1, highBloodScript2, highBloodScript3};
            CheckBox[] cholesterolScripts = {highCholesterolScript1, highCholesterolScript2, highCholesterolScript3};
            CheckBox[] kidneyScripts = {kidneyScript1, kidneyScript2, kidneyScript3};
            CheckBox[] liverScripts = {liverScript1, liverScript2, liverScript3};
            CheckBox[] boneScripts = {boneScript1, boneScript2, boneScript3};

            CheckBox[][] scripts = {bloodScripts, cholesterolScripts, kidneyScripts, liverScripts, boneScripts};
            CheckBox[] diagnoses = { highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};

            Condition[] conditions = currentPatient.getDiagnosis().getConditions();

            //look through all diagnoses and update values and state
            for(int i = 0; i < 5; i++){
                Prescription[] prescriptions = conditions[i].getValidPrescriptions();
                if (diagnoses[i].isSelected()){//make corresponding scripts available
                    currentPatient.getDiagnosis().setIsDiagnosed(true, i);
                    for(int j = 0; j < 3; j++)
                    {
                        scripts[i][j].setDisable(false);
                    }

                }else {//make corresponding scripts unavailable
                    currentPatient.getDiagnosis().setIsDiagnosed(false, i);
                    for(int j = 0; j < 3; j++)
                    {
                        scripts[i][j].setDisable(true);
                        scripts[i][j].setSelected(false);
                        prescriptions[j].setPrescribed(false);
                    }
                }
            }
        }
    }

    /**updates prescriptions based on prescription selection
     * @param event, The selection of a prescription
     */
    public void updateScripts(ActionEvent event) {
        if(currentPatient != null) {
            CheckBox[] bloodScripts = {highBloodScript1, highBloodScript2, highBloodScript3};
            CheckBox[] cholesterolScripts = {highCholesterolScript1, highCholesterolScript2, highCholesterolScript3};
            CheckBox[] kidneyScripts = {kidneyScript1, kidneyScript2, kidneyScript3};
            CheckBox[] liverScripts = {liverScript1, liverScript2, liverScript3};
            CheckBox[] boneScripts = {boneScript1, boneScript2, boneScript3};

            CheckBox[][] scripts = {bloodScripts, cholesterolScripts, kidneyScripts, liverScripts, boneScripts};
            CheckBox[] diagnoses = { highBloodPressure, highCholesterol, kidneyDisease, liverDisease, brokenHumerus};
            Condition[] conditions = currentPatient.getDiagnosis().getConditions();

            //look through all prescriptions and update values and state
            for (int i = 0; i < 5; i++) {
                Prescription[] prescriptions = conditions[i].getValidPrescriptions();
                for(int j = 0; j < 3; j++)
                {
                    prescriptions[j].setPrescribed(scripts[i][j].isSelected());
                }
            }
        }
    }

    private void addListenerToTextField(TextInputControl text, Patient patient, PatientUpdater updater) {
        ChangeListener<Boolean> listener = (observable, oldValue, newValue) -> {
            if (!newValue) {
                updater.apply(patient, text.getText());
                if((text == firstName || text == lastName || text == birthday) && currentPatient != null){
                    String key = lastName.getText() + firstName.getText() + birthday.getText();
                    Main.database.updateKey(currentKey, key);
                    currentKey = key;
                }

            }
        };
        System.out.println(currentPatient +"Adding focus lost listener to: " + text.getId());
        listenerMap.put(text, listener);
        text.focusedProperty().addListener(listener);
    }

    private void removeListenerFromTextField(TextInputControl text) {
        ChangeListener<Boolean> listener = listenerMap.remove(text);
        if (listener != null) {
            text.focusedProperty().removeListener(listener);
        }
        System.out.println(currentPatient + "Removing focus lost listener to: " + text.getId());
    }
    public void dischargeButton(ActionEvent event){
        if(currentPatient != nullPatient){
            //if patient has had there discharge started by a nurse, and the current user is a doctor, complete discharge
            if (passedPosition instanceof Doctor && currentPatient.isStartedDischarged()){
                currentPatient.setDischarged(true);
                unloadPatient();
            }else if (passedPosition instanceof Nurse && !currentPatient.isStartedDischarged()){
                currentPatient.setDischarged(true);
                dischargeButton.setDisable(true);
                admitButton.setDisable(true);

                //set stay of patient;
                Random rand = new Random();
                currentPatient.setDischargeDate(LocalDate.now().plusDays(rand.nextInt((10) + 2)));
                currentPatient.setDischarged(true);
            }
        }
    }

    public void admitButton (ActionEvent event){
        if (passedPosition instanceof EmergencyRoomStaff && !(passedPosition instanceof Nurse)){
            TextField[] newPatientFeilds = {lastName, firstName, birthday, address, cellPhone, insurance, emergencyCell};
            boolean empty = true;

            for (TextField feild: newPatientFeilds) {
                empty = Objects.equals(feild.getText(), "");
            }

            if(!empty){
                EmergencyRoomStaff staff = (EmergencyRoomStaff) passedPosition;
                staff.createPatient(lastName.getText(), firstName.getText(), birthday.getText(), address.getText(), cellPhone.getText(), insurance.getText(), emergencyCell.getText());

                for (TextField field: newPatientFeilds) { //reset textbox's
                    field.setText("");
                }
            }//OTHERWISE WARNING!
        } else if (passedPosition instanceof Nurse && currentPatient != null && !currentPatient.isAdmitted() && currentPatient != nullPatient) {
            //update patient information
            currentPatient.setAdmitted(true);
            currentPatient.setAdmittedDate(LocalDate.now());

            //update UI
            patientStatus.setText("Patient Status: Admitted");
            admitButton.setDisable(true);
            }
    }

    /**
     * Display a warning message.
     *
     * @param message The warning message to be displayed.
     */
    @Override
    public void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Warning Dialog");
        alert.setContentText(message);
        alert.showAndWait();

        loadFields();
    }
}
