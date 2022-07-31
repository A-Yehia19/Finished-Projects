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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Objects;

public class CustomerLoginForm {
    public static Pane returnForm(Stage stage) {
        HBox hlogin = new HBox(40);
        Label login = new Label("Login");
        login.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR,30));
        Image image= new Image(passer.image);
        ImageView imageView= new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setFitHeight(63);
        hlogin.getChildren().addAll(imageView,login);
        ////////////////////////////////////////////////////////////////

        HBox huser =new HBox(45);
        Label user = new Label("User name");
        user.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR,15));
        TextField textField= new TextField();
        textField.setPrefWidth(200);
        huser.getChildren().addAll(user,textField);
        //////////////////////////////////////////////////////////////////

        HBox hphone = new HBox(16);
        Label phonenumber = new Label("Phone number");
        phonenumber.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR,15));
        TextField textField1 = new TextField();
        textField1.setPrefWidth(200);
        hphone.getChildren().addAll(phonenumber,textField1);
        ////////////////////////////////////////////////////////////
        HBox hbutton = new HBox(10);
        Button button = new Button("Login");
        button.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR,20));
        button.setPrefWidth(96);
        button.setPrefHeight(40);
       hbutton.setAlignment(Pos.CENTER);
        hbutton.getChildren().add(button);




        Label invalid = new Label("Invalid data .. please try again");
        invalid.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, FontPosture.REGULAR,20));
        invalid.setTextFill(Color.RED);
        invalid.setOpacity(0);

        VBox vBox= new VBox(60);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(hlogin,huser,hphone,invalid,hbutton);
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //initialize database connection
        InputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(passer.key);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        GoogleCredentials credentials = null;
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



        //load scene and show stage
        Scene scene = new Scene(vBox, 355, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

//retreive data
//        DocumentReference docRef = db.collection("users").document("Reem");
//        ApiFuture<DocumentSnapshot> future = docRef.get();
//        DocumentSnapshot document = future.get();
//        if (document.exists())
//        {
//            textField.setText("nennenenne");
//        }
//        else {
//            textField.setText("Annenenennene");
//        }


        button.setOnAction(event ->
        {
            try
            {
                DocumentReference docRef = db.collection("users").document(textField.getText());
                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot document = null;
                document = future.get();

                //String x = document.getString("phonenumber");
                if (    (   document.exists())   &&   ( (Objects.equals(textField1.getText(),document.getString("phonenumber") ))  )  ) {
                        FXMLLoader home = new FXMLLoader(yummies.project.CustomerLoginForm.class.getResource("NewOrder.fxml"));
                        Stage nextStage = new Stage();
                        Scene scene2 = new Scene(home.load());
                        nextStage.setTitle("Make Your Order");
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
//
//
//
//            try {
//                ApiFuture<QuerySnapshot> query = db.collection("users").get();
//                QuerySnapshot querySnapshot = query.get();
//                List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
//                for (QueryDocumentSnapshot document2 : documents) {
//                    if (document2.contains(Objects.requireNonNull(document2.getString("phonenumber"))))
//
//                        if (Objects.equals(document2.getString("phonenumber"), textField1.getText())) {
//                            System.out.println("nenennene");
//                        } else {
//                            System.out.println("Anenenennenene");
//                        }
//
//                }
//            }
//        catch (Exception e)
//            {
//                invalid.setOpacity(1);
//            }





       });

//////////////sending data
//        DocumentReference docRef2 = db.collection("users").document("Haresa");
//        Map<String, Object> data = new HashMap<>();
//        data.put("phonenumber", "0101020");
//        ApiFuture<WriteResult> result = docRef2.set(data);

/////////////////////////////////
//         ApiFuture<QuerySnapshot> query = db.collection("users").get();
//        QuerySnapshot querySnapshot = query.get();
//        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
//        for (QueryDocumentSnapshot document2 : documents) {
//         //    if (document2.contains(Objects.requireNonNull(document2.getString("phonenumber"))))
//
//                if (Objects.equals(document2.getString("phonenumber"), "01010333"))
//                {
//                    System.out.println("nenennene");
//                }
//                else
//                {
//                    System.out.println("Anenenennenene");
//                }
////////////////////////////////////////



        //}


        return null;
    }
}