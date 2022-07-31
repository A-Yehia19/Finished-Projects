module com.example.chatting {
    requires javafx.controls;
    requires javafx.fxml;


    opens yummies.project to javafx.fxml;
    exports yummies.project;
}