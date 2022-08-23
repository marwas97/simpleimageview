module com.example.simpleimageview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.simpleimageview to javafx.fxml;
    exports com.example.simpleimageview;
}