module com.example.myfilemanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.myfilemanager to javafx.fxml;
    exports com.example.myfilemanager;
}