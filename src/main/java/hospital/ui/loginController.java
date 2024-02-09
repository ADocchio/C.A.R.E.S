package hospital.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        if(username.getText().equals("123") && password.getText().equals("123")) {
            loginError.setText("Login Successful!");

            interfaceLoad.changeScene("main-view.fxml", 1110, 1930);
        } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
            loginError.setText("Enter All Fields!");
        } else {
            loginError.setText("Incorrect Username or Password");
        }
    }
}