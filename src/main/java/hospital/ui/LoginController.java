package hospital.ui;

import hospital.ui.database.Database;
import hospital.ui.users.staff.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Hashtable;

public class LoginController {

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

        double width = 1920;
        double height = 1080;
        String loginKey = username.getText() + password.getText();
        Hashtable<String, Staff> loginTable = Main.database.getLoginTable();

        if(loginTable.containsKey(loginKey)){
            Staff user = loginTable.get(loginKey);
            loginError.setText("Login Successful!");
            MainViewController.passedPosition = user;
            InterfaceLoad.changeScene("main-view.fxml", height, width, "C.A.R.E.S Dashboard");
        }else {
            loginError.setText("Incorrect Username or Password");
            username.setText("");
            password.setText("");
        }
    }
}