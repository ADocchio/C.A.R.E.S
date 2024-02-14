package hospital.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

import java.io.IOException;

public class loginController {

    public loginController() {

    }

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginError;

    /**Handles the login of the user
     *
     * @param event, When "Login" button is clicked
     * @throws IOException, if checkLogin method throws an error
     */
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    /**Makes sure login cordials are valid, gives user information on state of credentials entered
     *
     * @throws IOException, If main-view.fxml can not be found or has errors
     */
    private void checkLogin() throws IOException {

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        //TEMP TEST CODE
        if(username.getText().equals("Doctor") && password.getText().equals("123")) {
            loginError.setText("Login Successful!");
            mainViewController.passedRole = "Doctor";

            interfaceLoad.changeScene("main-view.fxml", height, width, "C.A.R.E.S Dashboard");
        } else if (username.getText().equals("Nurse") && password.getText().equals("123")) {
            loginError.setText("Login Successful!");
            mainViewController.passedRole = "Nurse";

            interfaceLoad.changeScene("main-view.fxml", height, width, "C.A.R.E.S Dashboard");
        } else if (username.getText().equals("Staff") && password.getText().equals("123")) {
            loginError.setText("Login Successful!");
            mainViewController.passedRole = "Staff";

            interfaceLoad.changeScene("main-view.fxml", height, width, "C.A.R.E.S Dashboard");
        } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
            loginError.setText("Enter All Fields!");
        } else {
            loginError.setText("Incorrect Username or Password");
            username.setText("");
            password.setText("");
        }
    }
}