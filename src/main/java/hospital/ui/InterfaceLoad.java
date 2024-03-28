package hospital.ui;

import hospital.ui.database.Database;
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


public class InterfaceLoad extends Application {

    private static Stage primaryStage; //creates a stage to host the application in


    /** Launch's the application
     *
     */
    public static void startApp() {
       Main.database.loadDataBase();
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        InterfaceLoad.primaryStage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(InterfaceLoad.class.getResource("login.fxml")); //loads login fxml
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); //set login window size
        primaryStage.setTitle("C.A.R.E.S Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop(){
        Main.database.saveDatabase();
        System.out.println("Application is about to stop.");

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
