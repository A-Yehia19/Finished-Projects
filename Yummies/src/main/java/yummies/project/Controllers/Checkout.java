package yummies.project.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import yummies.project.Classes.*;
import yummies.project.Main;
import yummies.project.passer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Checkout {
    public Button confirm_btn;
    public TextField addressTF;
    public TextField CardNoTF;
    public TextField EXPDateTF;
    public TextField PIN_TF;
    public RadioButton cardRadio;
    public HBox cardDetails;
    public RadioButton cashRadio;
    public CheckBox delivery_check;
    public Label total;
    public Label mainDish;
    public Label sideDish;
    public Label appetizer;
    public Label dessert;
    public Label drink;
    public Label warning;
    public TextField paid;

    Customer customer;
    Order order;

    public void initialize(){
        customer=passer.customer;
        order=passer.order;

        mainDish.setText(order.MainDish);
        sideDish.setText(order.SideDish);
        appetizer.setText(order.Appetizer);
        dessert.setText(order.Dessert);
        drink.setText(order.Drink);
        total.setText(String.valueOf(order.Price));
    }

    public void cashSelected(ActionEvent actionEvent) {
        cardRadio.setSelected(false);
        CardNoTF.setDisable(true);
        EXPDateTF.setDisable(true);
        PIN_TF.setDisable(true);
        cardDetails.setOpacity(0);
        if (cashRadio.isSelected()){
            paid.setDisable(false);
            paid.setOpacity(1);
        }else{
            paid.setDisable(true);
            paid.setOpacity(0);
        }
    }

    public void cardSelected(ActionEvent actionEvent) {
        if (cardRadio.isSelected()){
            paid.setDisable(true);
            paid.setOpacity(0);
            cashRadio.setSelected(false);
            CardNoTF.setDisable(false);
            EXPDateTF.setDisable(false);
            PIN_TF.setDisable(false);
            cardDetails.setOpacity(1);
        }else{
            CardNoTF.setDisable(true);
            EXPDateTF.setDisable(true);
            PIN_TF.setDisable(true);
            cardDetails.setOpacity(0);
        }
    }

    public void checked(ActionEvent actionEvent) {
        if (delivery_check.isSelected()){
            total.setText(String.valueOf(Double.parseDouble(total.getText())+10));
            addressTF.setOpacity(1);
            addressTF.setDisable(false);
        }else {
            total.setText(String.valueOf(Double.parseDouble(total.getText())-10));
            addressTF.setOpacity(0);
            addressTF.setDisable(true);
        }
    }

    public void confirmed(ActionEvent actionEvent) throws IOException {
        Booking booking = new Booking();

        if(!cardRadio.isSelected() && !cashRadio.isSelected())
            warning.setOpacity(1);
        else{
            if (Double.parseDouble(total.getText()) > Double.parseDouble(paid.getText())){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Insufficient Amount");
                alert.show();
            }else{
                try{
                    booking.IsDelivery = delivery_check.isSelected();
                    if (delivery_check.isSelected()){
                        booking.Address=addressTF.getText();
                    }

                    if (cashRadio.isSelected()){
                        booking.PaymentMethode = new Cash(order.Price, Double.parseDouble(paid.getText()));
                    }else{
                        booking.PaymentMethode = new Card(order.Price, Integer.parseInt(CardNoTF.getText()), PIN_TF.getText(), EXPDateTF.getText());
                    }
                    order.Price=Double.parseDouble(total.getText());
                    booking.order=order;
                    customer.SetBooking(booking);

                    Stage thisStage = (Stage)((Node)((EventObject) actionEvent).getSource()).getScene().getWindow();
                    thisStage.hide();

                    FXMLLoader next = new FXMLLoader(Main.class.getResource("Finishing.fxml"));
                    Stage nextStage = new Stage();
                    Scene nextScene = new Scene(next.load());
                    nextStage.setTitle("Finishing...");
                    nextStage.setScene(nextScene);
                    nextStage.show();
                }catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Invalid Data!!\nPlease enter Amount properly.");
                    alert.show();
                }
            }
        }
    }
}

