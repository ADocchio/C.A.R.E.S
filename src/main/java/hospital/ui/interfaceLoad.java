package hospital.ui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class interfaceLoad extends Application {

    private static Stage primaryStage; //creates a stage to host the application in

    /** Launch's the application
     *
     */
    public static void startApp() {
        launch();
    }




    @Override
    public void start(Stage primaryStage) throws IOException {
        interfaceLoad.primaryStage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(interfaceLoad.class.getResource("login.fxml")); //loads login fxml
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); //set login window size
        primaryStage.setTitle("C.A.R.E.S Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**Changes the scene that is displayed on the main JAVAFX scene
     *
     * @param fxml, fxml file to be displayed
     * @param height, height of stage
     * @param width, width of stage
     * @param title, title of scene
     * @throws IOException, if fxml files is not found or has errors
     */
    public static void changeScene(String fxml, double height, double width, String title) throws IOException {

        try {
            double originalWidth = 1920; // Original width of the content
            double originalHeight = 1080; // Original height of the content
            double aspectRatio = originalWidth / originalHeight;

            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(interfaceLoad.class.getResource(fxml)));
            Parent pane = loader.load();
            primaryStage.setWidth(width);
            primaryStage.setHeight(height);
            primaryStage.setTitle(title);
            primaryStage.setResizable(true);
            primaryStage.getScene().setRoot(pane);

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
