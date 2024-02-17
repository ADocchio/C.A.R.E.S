package hospital.ui;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ScalingExample extends Application {
    public static void startApp() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(interfaceLoad.class.getResource("main-view.fxml")); //loads login fxml

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double screenWidth = 1366.0;
        double screenHeight = 768.0;
        double screenAspectRatio = screenWidth / screenHeight;
        double scaleFactorX = screenWidth / 1920.0;
        double scaleFactorY = screenHeight / 1080.0;

        Scene scene = new Scene(fxmlLoader.load(), screenWidth, screenHeight); //set login window size
        primaryStage.setTitle("C.A.R.E.S Login");
        primaryStage.setScene(scene);

        System.out.println(scaleFactorX);
        System.out.println(scaleFactorY);

        Parent pane = scene.getRoot();
        Parent parent = scene.getRoot(); // You're sure it's an AnchorPane
        AnchorPane anchorPane = (AnchorPane) parent;
        pane.setScaleX(scaleFactorX);
        pane.setScaleY(scaleFactorY);

        primaryStage.show();

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            // Calculate the new X position to keep the AnchorPane at the top-right corner
            double newXPosition = newVal.doubleValue() + anchorPane.getPrefWidth() * scaleFactorX;
            // Apply the new position
            anchorPane.setLayoutX(newXPosition);
        });

        // Initial positioning
        anchorPane.setLayoutX(scene.getWidth() + anchorPane.getPrefWidth() * scaleFactorX);
        anchorPane.setLayoutY(0); // Keep it at the top




    }

    public static void main(String[] args) {
        launch(args);
    }
}


