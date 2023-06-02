module com.example.annivnathan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.annivnathan to javafx.fxml;
    exports com.example.annivnathan;
}