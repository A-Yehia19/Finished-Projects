package yummies.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(HelloApplication.class.getResource("massenger.fxml"));
        //Parent root = FXMLLoader.load(HelloApplication.getClass().getResource("hello-view.fxml"));
        stage.setTitle("Server!");
        stage.setScene(new Scene(root.load()));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}