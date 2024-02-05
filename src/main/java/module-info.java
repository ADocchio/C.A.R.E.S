module hospital.ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens hospital.ui to javafx.fxml;
    exports hospital.ui;
}