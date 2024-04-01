package hospital.ui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Manages the user interface for the application, handling the loading of FXML files,
 * switching scenes, and initializing and stopping the application.
 */
public class InterfaceLoad extends Application {

    private static Stage primaryStage; // Hosts the primary stage of the application

    /**
     * Launches the application. This method is intended to be called to initiate the JavaFX application,
     * loading the initial database and setting up the primary stage.
     */
    public static void startApp() {
        Main.database.loadDataBase();
        launch();
    }

    /**
     * Starts the primary stage of the application, setting up the initial scene from an FXML file.
     * This method initializes the primary stage with a login screen, preparing the user interface
     * for interaction.
     *
     * @param primaryStage The primary stage for this application, onto which the scene is set.
     * @throws IOException If there is an issue loading the FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        InterfaceLoad.primaryStage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(InterfaceLoad.class.getResource("login.fxml")); // Loads login FXML
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // Sets login window size
        primaryStage.setTitle("C.A.R.E.S Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Invoked when the application should stop, and performs any necessary cleanup before exiting.
     * This method ensures that the database is saved before the application is closed.
     */
    @Override
    public void stop() {
        Main.database.saveDatabase();
        System.out.println("Application is about to stop.");
    }

    /**
     * Changes the scene displayed on the main JavaFX stage.
     * This method allows dynamically changing the content displayed to the user, based on the
     * application's state or user interactions.
     *
     * @param fxml   The path to the FXML file that defines the new scene.
     * @param height The height of the stage after the scene change.
     * @param width  The width of the stage after the scene change.
     * @param title  The title of the stage to be displayed.
     * @throws IOException If the specified FXML file is not found or cannot be loaded.
     */
    public static void changeScene(String fxml, double height, double width, String title) throws IOException {

        try {
            final Pane root = new Pane();

            Pane pane = FXMLLoader.load(Objects.requireNonNull(InterfaceLoad.class.getResource(fxml)));   //initial view
            pane.setPrefWidth(width);
            pane.setPrefHeight(height);
            root.getChildren().add(pane);

            Scale scale = new Scale(1, 1, 0, 0);
            scale.xProperty().bind(root.widthProperty().divide(width));
            scale.yProperty().bind(root.heightProperty().divide(height));
            root.getTransforms().add(scale);

            final Scene scene = new Scene(root, width, height);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);

            primaryStage.show();
            scene.rootProperty().addListener(new ChangeListener<Parent>() {
                @Override
                public void changed(ObservableValue<? extends Parent> arg0, Parent oldValue, Parent newValue) {
                    scene.rootProperty().removeListener(this);
                    scene.setRoot(root);
                    ((Region) newValue).setPrefWidth(width);
                    ((Region) newValue).setPrefHeight(height);
                    root.getChildren().clear();
                    root.getChildren().add(newValue);
                    scene.rootProperty().addListener(this);
                }

            });

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


}
