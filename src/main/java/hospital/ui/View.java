package hospital.ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class View {

    @FXML
    public TextField weightForm;

    public void initialize() {
        weightForm.setText(String.valueOf(Main.person.getWeight()));
        setupTextFieldHandlers();
    }

    private void setupTextFieldHandlers() {

        // Handle pressing Enter
        weightForm.setOnAction(event -> {
            String lastValidValue = String.valueOf(Main.person.getWeight());

            if (isNumeric(weightForm.getText())) {
                lastValidValue = weightForm.getText();
                Main.person.setWeight(Double.parseDouble(lastValidValue ));
            } else {
                weightForm.setText(lastValidValue);
            }
        });

        // Handle losing focus
        weightForm.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                String lastValidValue = String.valueOf(Main.person.getWeight());

                if (isNumeric(weightForm.getText())) {
                    lastValidValue = weightForm.getText();
                    Main.person.setWeight(Double.parseDouble(lastValidValue ));
                } else {
                    weightForm.setText(lastValidValue);
                }
            }
        });
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


    public void inject(String value){
        weightForm.setText(value);
    }
}
