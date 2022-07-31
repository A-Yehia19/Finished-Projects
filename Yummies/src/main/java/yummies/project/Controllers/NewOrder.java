package yummies.project.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import yummies.project.Classes.Customer;
import yummies.project.Classes.Order;
import yummies.project.Main;
import yummies.project.passer;

import java.io.IOException;
import java.util.EventObject;

public class NewOrder {
    public ComboBox mainDish;
    public ComboBox sideDish;
    public ComboBox appetizer;
    public ComboBox dessert;
    public ComboBox drink;
    public Button checkout;
    public Label total;

    Customer customer;

    public void initialize (){
        customer = new Customer();

        mainDish.getItems().addAll("--","Beef","Chicken", "Meat Loaf");
        sideDish.getItems().addAll("--","Pasta","Rice");
        appetizer.getItems().addAll("--","Salad","Bread", "Soup");
        dessert.getItems().addAll("--","Brownies","Cake", "Cookies", "katakito");
        drink.getItems().addAll("--","Smoothie Mix Berry","juice", "Coffee", "Rani 7obibat Mango");
    }

    public void selected(ActionEvent actionEvent) {
        int tot = 0;

        //Main Dish
        if (mainDish.getValue()=="Beef")
            tot+=50;
        else if (mainDish.getValue()=="Chicken")
            tot+=45;
        else if (mainDish.getValue()=="Meat Loaf")
            tot+=40;

        //Side Dish
        if (sideDish.getValue()=="Rice")
            tot+=15;
        else if (sideDish.getValue()=="Pasta")
            tot+=20;

        //Appetizer
        if (appetizer.getValue()=="Salad")
            tot+=10;
        else if (appetizer.getValue()=="Bread")
            tot+=5;
        else if (appetizer.getValue()=="Soup")
            tot+=10;

        //Dessert
        if (dessert.getValue()=="Brownies")
            tot+=20;
        else if (dessert.getValue()=="Cake")
            tot+=18;
        else if (dessert.getValue()=="Cookies")
            tot+=15;
        else if (dessert.getValue()=="katakito")
            tot+=6;

        //Drink
        if (drink.getValue()=="Smoothie Mix Berry")
            tot+=20;
        else if (drink.getValue()=="juice")
            tot+=17;
        else if (drink.getValue()=="Coffee")
            tot+=25;
        else if (drink.getValue()=="Rani 7obibat Mango")
            tot+=10;

        total.setText(String.valueOf(tot));
    }

    public void checkout_btn(ActionEvent actionEvent) throws IOException {
        if(!total.getText().equals("00") && !total.getText().equals("0")){
            Order order = new Order();
            order.SetOrder( decode((String) mainDish.getValue()),
                            decode((String) sideDish.getValue()),
                            decode((String) appetizer.getValue()),
                            decode((String) dessert.getValue()),
                            decode((String) drink.getValue()),
                            Double.parseDouble(total.getText()) );

            passer.order=order;
            passer.customer=customer;

            FXMLLoader next = new FXMLLoader(Main.class.getResource("Checkout.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(next.load());
            stage.setTitle("Checkout");
            stage.setScene(scene);
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please Fill your order!!");
            alert.show();
        }
    }

    String decode (String in){
        if (in=="" || in==null)
            return "--";
        return in;
    }

    public void ViewOrders(MouseEvent mouseEvent) throws IOException {
        passer.history=customer.ViewBookings();

        FXMLLoader next = new FXMLLoader(Main.class.getResource("ViewAllOrders.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(next.load());
        stage.setTitle("Order History");
        stage.setScene(scene);
        stage.show();
    }
}
