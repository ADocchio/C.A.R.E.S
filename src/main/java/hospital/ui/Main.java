package hospital.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class Main extends Application {

    private static Stage stg;
    public static Person emergencyContact = new Person(
            "Jane", // firstName
            "Doe", // lastName
            "123 Elm Street, Springfield", // address
            "None", // insurance
            "555-0123", // phoneNumber
            null, // emergencyContact (None for this example)
            "Friend", // role
            "E12345", // id
            60.0, // weight in kg
            165.0, // height in cm
            72 // bpm
    );

    // Creating a main person object with the emergency contact set
    public static Person person = new Person(
            "John", // firstName
            "Smith", // lastName
            "456 Maple Avenue, Anytown", // address
            "HealthPlus Insurance", // insurance
            "555-6789", // phoneNumber
            emergencyContact, // emergencyContact
            "Patient", // role
            "P98765", // id
            75.0, // weight in kg
            180.0, // height in cm
            65 // bpm
    );

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setTitle("C.A.R.E.S Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(fxml)));
            Parent pane = loader.load();
            stg.getScene().setRoot(pane);

        } catch (IOException e) {
            // Handle IO problems (e.g., file not found, cannot read file)
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // Handle issues related to FXMLLoader setup
            e.printStackTrace();
        } catch (Exception e) {
            // Catch-all for any other exceptions
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
