package yummies.project;

import com.google.firebase.internal.HttpRequestInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.nio.file.Paths;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        music();
        FXMLLoader home = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(home.load());
        stage.setTitle("Yummies!");
        stage.setScene(scene);
        stage.show();
    }

    MediaPlayer mediaPlayer;

    public void music() {
        String s = "yummy.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch();
    }
}