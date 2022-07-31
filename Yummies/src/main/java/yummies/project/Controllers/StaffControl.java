package yummies.project.Controllers;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import yummies.project.Classes.*;
import yummies.project.CustomerLoginForm;
import yummies.project.Main;
import yummies.project.StaffLoginForm;
import yummies.project.passer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class StaffControl {
    public Label hello;
    public Label id;
    public TextField idtxt;
    public Label maindish;
    public Label sidedish;
    public Label apetizer;
    public Label drink;
    public Label dessert;
    public CheckBox checktoremove;
    public CheckBox checktoaddcheff;
    public CheckBox checktoadddelviry;
    public Label name;
    public Label phonenumebr;
    public Label address;
    public Label salary;
    public TextField nametxt;
    public TextField phonenumbertxt;
    public TextField addresstxt;
    public TextField salarytxt;
    public Label newid;
    public Label staffsalarylabel;
    public Label ordernumber;
    public Chef chef;
    public Delivery delivery;
    public TextField txt;
    public TextField viewsalarytxt;
    public TextField deleivryremaningtxt;
    public Button makeorder;
    public Label makeordertxt;
    public Label deleivertxt;
    public Button removestaff;
    public Button addstaff;
    public TextArea ordersRemaining;
    public TextField IDtxtField;
    private Stage stage;


    public void openCustomer(ActionEvent actionEvent) {
        Stage thisStage = (Stage)((Node)((EventObject) actionEvent).getSource()).getScene().getWindow();
        CustomerLoginForm.returnForm(thisStage);
    }

    //method to open staff
    public void openstaff(ActionEvent actionEvent) throws IOException {
        Pane stafflogin = StaffLoginForm.returnForm();
        Scene scene = new Scene(stafflogin);
        stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

      // method to open cheff
    public void opencheff(ActionEvent actionEvent) throws IOException {


        //check contdion to check if id value == to id of cheff
        chef=new Chef();
       // chef.ID=Integer.parseInt(idtxt.getText());
        if(Integer.parseInt(idtxt.getText())==chef.ID) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("chief-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }



    }

    //method to show cheff current order
    public void currentorder(ActionEvent actionEvent) {
        try {
            chef = (Chef) passer.staff;
            maindish.setText(chef.OrdersID.get(0).order.MainDish);
            sidedish.setText(chef.OrdersID.get(0).order.SideDish);
            apetizer.setText(chef.OrdersID.get(0).order.Appetizer);
            drink.setText(chef.OrdersID.get(0).order.Drink);
            dessert.setText(chef.OrdersID.get(0).order.Dessert);
            makeordertxt.setText("--");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Congratulation!! all orders are done");
            alert.show();
        }
    }

    // method to remove worker from staff by manger by entering id
    public void remove(ActionEvent actionEvent) throws ExecutionException, InterruptedException, IOException {
        if(checktoremove.isSelected())
        {
            passer.passedID=idtxt.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reCAPTCHA.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Not Robot?");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void openmanger(ActionEvent actionEvent) throws IOException {
        //check contdion to check if id value == to id of manger
        //if(Integer.parseInt(idtxt.getText())==Manager.GetManager().ID) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manger-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        //}
    }

    // method to go to add new staff window
    public void addstaff(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addstaff-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // method to add new staff
    public void presstoadd(ActionEvent actionEvent) {
        InputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(passer.key);
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("key.json not found");
            alert.show();
        }
        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials.fromStream(serviceAccount);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Error in database");
            alert.show();
        }
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        //FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();


        ////////////////////////////////////////////////////////////////

        String id = IDtxtField.getText();
        String address = addresstxt.getText();
        String salary = salarytxt.getText();
        String name = nametxt.getText();
        String phoneNumber = phonenumbertxt.getText();
        
       if(checktoaddcheff.isSelected()) {
            try{
                Manager.GetManager().Add(Integer.parseInt(id),Double.parseDouble(salary),"chef",name);

                //sending data
                DocumentReference docRef2 = db.collection("staff").document(id);
                Map<String, Object> data = new HashMap<>();
                data.put("phonenumber", phoneNumber);
                data.put("address", address);
                data.put("salary", salary);
                data.put("name", name);
                data.put("type", "chef");
                ApiFuture<WriteResult> result = docRef2.set(data);
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Invalid Data Format");
                alert.show();
            }

        } else if (checktoadddelviry.isSelected())
        {
            try{
                Manager.GetManager().Add(Integer.parseInt(id),Double.parseDouble(salary),"delivery",name);

                DocumentReference docRef2 = db.collection("staff").document(id);
                Map<String, Object> data = new HashMap<>();
                data.put("phonenumber", phoneNumber);
                data.put("address", address);
                data.put("salary", salary);
                data.put("name", name);
                data.put("type", "delivery");
                ApiFuture<WriteResult> result = docRef2.set(data);
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Invalid Data Format");
                alert.show();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("please choose delivery or staff");
            alert.show();
        }

    }

    // method to view staff salary
    public void viewstaffsalary(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("staffsalary-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage nextStage=new Stage();
        nextStage.setScene(scene);
        nextStage.show();
    }

    //method to open delivery
    public void opendelievry(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("delievry-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage=(Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //method to view current order number
    public void currentorderdelivery(ActionEvent actionEvent) {
        try{
            delivery = (Delivery) passer.staff;
            int id = delivery.Finished.get(0).BookingID;
            ordernumber.setText(String.valueOf(id));
            deleivertxt.setText("--");
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Congratulation!! all orders are done");
            alert.show();
        }
    }


    public void makeorder(ActionEvent actionEvent) {
        try{
            chef = (Chef) passer.staff;
            chef.Work(0);
            makeordertxt.setText("Done");
            passer.staff = chef;
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No orders found");
            alert.show();
        }
    }

    public void deliver(ActionEvent actionEvent) {
        try{
            delivery = (Delivery) passer.staff;
            delivery.Work(0);
            deleivertxt.setText("Delivery Done");
            passer.staff=delivery;
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No orders found");
            alert.show();
        }
    }

    public void chefChecked(ActionEvent actionEvent) {
        if (checktoadddelviry.isSelected())
            checktoadddelviry.setSelected(false);

    }

    public void deliveryChecked(ActionEvent actionEvent) {
        if (checktoaddcheff.isSelected())
            checktoaddcheff.setSelected(false);
    }

    // method to view remaining delivery orders arraylist
    public void viewOrderRemaining(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("orderRemaming-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage nextStage=new Stage();
        nextStage.setTitle("Order Remaining");
        nextStage.setScene(scene);
        nextStage.show();
    }

    public void checkRemove(ActionEvent actionEvent) {
        if(checktoremove.isSelected())
            removestaff.setDisable(false);
        else
            removestaff.setDisable(true);
    }
}