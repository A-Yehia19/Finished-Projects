package yummies.project;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import yummies.project.Classes.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class StaffLoginForm {
    public static Pane returnForm(){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(70));

        Label header = new Label("Staff Login");
        header.setPadding(new Insets(0,0,20,0));
        header.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR, 25));

        Label invalid = new Label("Invalid ID");
        invalid.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        invalid.setOpacity(0);
        invalid.setTextFill(Color.RED);



        HBox row = new HBox(5);
        row.setAlignment(Pos.CENTER);
        Label id = new Label("ID: ");
        id.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField IdTextField = new TextField();
        IdTextField.setPrefWidth(200);
        row.getChildren().addAll(id, IdTextField);

        Button manager = new Button("Manager");
        manager.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        manager.setPrefHeight(50);
        manager.setPrefWidth(140);
        Button chef = new Button("Chef");
        chef.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        chef.setPrefHeight(50);
        chef.setPrefWidth(140);
        Button delivery = new Button("Delivery");
        delivery.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        delivery.setPrefHeight(50);
        delivery.setPrefWidth(140);

        pane.getChildren().addAll(header,row,invalid,manager,chef,delivery);
        ///////////////////////////////////////////////////////////////////////////////

        //initialize database connection
        InputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream(passer.key);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        GoogleCredentials credentials;
        try {
            credentials = GoogleCredentials.fromStream(serviceAccount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();

        ////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        manager.setOnAction(event -> {
            try
            {
                DocumentReference docRef = db.collection("staff").document(IdTextField.getText());
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot document;
                document = future.get();

                String x =document.getString("type");
                //System.out.println(x);
                if ( ( document.exists()) && (Objects.equals(x, "manager")) ) {



                    ApiFuture<QuerySnapshot> query = db.collection("staff").get();
                    QuerySnapshot querySnapshot = query.get();
                    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
                    for (QueryDocumentSnapshot thisDocument : documents) {
                        String phoneNumber = thisDocument.getString("phonenumber");
                        String ID = thisDocument.getId();
                        String Address = thisDocument.getString("address");
                        String Salary = thisDocument.getString("salary");
                        String Name = thisDocument.getString("name");
                        String Type = thisDocument.getString("type");
                        Staff thisStaff;

                        if(Objects.equals(Type, "chef")){
                            thisStaff = new Chef(Name,phoneNumber,Address,Integer.parseInt(ID),Double.parseDouble(Salary));
                            Manager.GetManager().staff.add(thisStaff);
                        }else if(Objects.equals(Type, "delivery")){
                            thisStaff = new Delivery(Name,phoneNumber,Address,Integer.parseInt(ID),Double.parseDouble(Salary));
                            Manager.GetManager().staff.add(thisStaff);
                        }
                    }

                    FXMLLoader home = new FXMLLoader(Main.class.getResource("manger-view.fxml"));
                    Stage nextStage = new Stage();
                    Scene scene2;
                    scene2 = new Scene(home.load());
                    nextStage.setTitle("Manager");
                    nextStage.setScene(scene2);
                    nextStage.show();
                    invalid.setOpacity(0);
                }
                else
                {
                    invalid.setOpacity(1);
                }

            }
            catch (Exception e)
            {
                invalid.setOpacity(1);
            }
        });

        chef.setOnAction(event -> {
            try {
                DocumentReference docRef = db.collection("staff").document(IdTextField.getText());
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot document= future.get();


                String phoneNumber = document.getString("phonenumber");
                String ID = IdTextField.getText();
                String Address = document.getString("address");
                String Salary = document.getString("salary");
                String Name = document.getString("name");


                String x =document.getString("type");
                //System.out.println(x);
                if ( ( document.exists())  &&   (Objects.equals(x, "chef"))        ) {
                    FXMLLoader home = new FXMLLoader(Main.class.getResource("cheff-view.fxml"));
                    Stage nextStage = new Stage();
                    Scene scene2 = new Scene(home.load());
                    nextStage.setTitle("Chef");
                    nextStage.setScene(scene2);
                    nextStage.show();
                    invalid.setOpacity(0);

                    Chef chef1 = new Chef(Name,phoneNumber,Address,Integer.parseInt(ID),Double.parseDouble(Salary));
                    Booking b1=new Booking();
                    Booking b2=new Booking();
                    Booking b3=new Booking();

                    b1.order.SetOrder("beef","pasta", "salad","","",20);
                    b1.BookingID=0;
                    b2.order.SetOrder("chicken","pasta", "","","smoothie mix berry",20);
                    b2.BookingID=1;
                    b3.order.SetOrder("","rice", "soup","cake","",20);
                    b3.BookingID=2;

                    chef1.OrdersID.add(b1);
                    chef1.OrdersID.add(b2);
                    chef1.OrdersID.add(b3);
                    passer.staff=chef1;
                }
                else
                {
                    invalid.setOpacity(1);
                }
            }catch (Exception e) {
                invalid.setOpacity(1);
            }
        });

        delivery.setOnAction(event -> {
            try {
                DocumentReference docRef = db.collection("staff").document(IdTextField.getText());
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot document = future.get();


                String phoneNumber = document.getString("phonenumber");
                String ID = IdTextField.getText();
                String Address = document.getString("address");
                String Salary = document.getString("salary");
                String Name = document.getString("name");


                String x =document.getString("type");
                //System.out.println(x);
                if ( ( document.exists())  &&   (Objects.equals(x, "delivery"))   ) {
                    FXMLLoader home = new FXMLLoader(Main.class.getResource("delievry-view.fxml"));
                    Stage nextStage = new Stage();
                    Scene scene2 = new Scene(home.load());
                    nextStage.setTitle("Delivery");
                    nextStage.setScene(scene2);
                    nextStage.show();
                    invalid.setOpacity(0);

                    Delivery delivery1 = new Delivery(Name,phoneNumber,Address,Integer.parseInt(ID),Double.parseDouble(Salary));
                    Booking b1=new Booking();
                    Booking b2=new Booking();
                    Booking b3=new Booking();

                    b1.order.SetOrder("beef","pasta", "salad","","",20);
                    b1.BookingID=0;
                    b2.order.SetOrder("chicken","pasta", "","","smoothie mix berry",20);
                    b1.BookingID=1;
                    b3.order.SetOrder("","rice", "soup","cake","",20);
                    b1.BookingID=2;

                    delivery1.Finished.add(b1);
                    delivery1.Finished.add(b2);
                    delivery1.Finished.add(b3);
                    passer.staff=delivery1;
                }
                else
                {
                    invalid.setOpacity(1);
                }
            }catch (Exception e) {
                invalid.setOpacity(1);
            }
        });

        ///////////////////////////////////////////////////////////////////////////////
        return pane;
    }
}
