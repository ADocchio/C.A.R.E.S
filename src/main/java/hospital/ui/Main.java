package hospital.ui;

import javafx.stage.Stage;

public class Main {

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

    public static void main(String[] args) {
        interfaceLoad.startApp();
    }
}
