module com.example.app_vivero_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens models to javafx.fxml;
    exports models;
}