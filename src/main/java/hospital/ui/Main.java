package hospital.ui;

import hospital.ui.database.Database;

/**
 * The main entry point for the JavaFX application.
 * This class initializes the application's primary resources and settings before launching the user interface.
 * It holds a static reference to the {@link Database} to ensure data persistence and accessibility throughout the application lifecycle.
 */
public class Main {

    /**
     * A static instance of {@link Database} accessible globally, used for managing application data.
     */
    public static Database database = new Database();

    /**
     * The main method that serves as the entry point of the application.
     * It initializes the user interface by calling the startApp method on the {@link InterfaceLoad} class.
     *00/00/0000
     * @param args Command line arguments passed to the application. These are not used in this application.
     */
    public static void main(String[] args) {
        InterfaceLoad.startApp();
    }
}
