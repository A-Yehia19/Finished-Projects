package yummies.project.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import yummies.project.Main;

import java.io.IOException;

public class NeedHelp {
    public void contact(ActionEvent actionEvent) throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource("ClientChat.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Client!");
        stage.setScene(new Scene(root.load()));
        stage.show();
        Stage thisStage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        thisStage.hide();
    }
}
