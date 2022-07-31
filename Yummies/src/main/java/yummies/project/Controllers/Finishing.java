package yummies.project.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import yummies.project.Main;

import java.io.IOException;
import java.util.EventObject;
import java.util.concurrent.TimeUnit;

public class Finishing {

    public void goNext(MouseEvent mouseEvent) throws IOException, InterruptedException {
        Stage thisStage = (Stage)((Node)((EventObject) mouseEvent).getSource()).getScene().getWindow();

        FXMLLoader next = new FXMLLoader(Main.class.getResource("Delivering.fxml"));
        Scene nextScene = new Scene(next.load());
        thisStage.setTitle("Delivering...");
        thisStage.setScene(nextScene);
        thisStage.show();
    }
}
