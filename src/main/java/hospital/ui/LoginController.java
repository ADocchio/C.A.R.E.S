package hospital.ui;

import hospital.ui.users.staff.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Controller class responsible for handling user login in the application.
 * It interacts with the UI elements defined in the corresponding FXML file for the login screen,
 * including input fields for the username and password, a login button, and a label for login errors.
 */
public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginError;
    private static LoginController instance;

    public static synchronized LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    /**
     * Handles the login button click event. It attempts to authenticate the user based on the
     * provided username and password.
     *
     * @param event The event triggered when the "Login" button is clicked.
     * @throws IOException If there is an issue navigating to the next screen upon successful login.
     */
    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    /**
     * Verifies the login credentials entered by the user. If the credentials are valid,
     * the method transitions the user to the main view of the application. If the credentials
     * are invalid, it displays an error message on the login screen.
     *
     * @throws IOException If the "main-view.fxml" file cannot be found or if there is an error loading it.
     */
    private void checkLogin() throws IOException {
        double width = 1920;
        double height = 1080;
        String loginKey = username.getText() + password.getText();
        Hashtable<String, Staff> loginTable = Main.database.getLoginTable();

        if (loginTable.containsKey(loginKey)) {
            Staff user = loginTable.get(loginKey);
            loginError.setText("Login Successful!");
            MainViewController.passedPosition = user; // Assuming this static field/method is defined elsewhere for context passing
            InterfaceLoad.changeScene("main-view.fxml", height, width, "C.A.R.E.S Dashboard");
        } else {
            loginError.setText("Incorrect Username or Password");
            username.clear();
            password.clear();
        }
    }
}