package yummies.project.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import yummies.project.Main;

import java.io.IOException;
import java.util.EventObject;

public class Done {
    public void goNext(MouseEvent mouseEvent) throws IOException, InterruptedException {
        Stage thisStage = (Stage)((Node)((EventObject) mouseEvent).getSource()).getScene().getWindow();
        thisStage.hide();

        FXMLLoader root = new FXMLLoader(Main.class.getResource("NeedHelp.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Help?");
        stage.setScene(new Scene(root.load()));
        stage.show();
    }
}
