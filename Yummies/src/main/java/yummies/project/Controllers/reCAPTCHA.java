package yummies.project.Controllers;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yummies.project.Classes.Manager;
import yummies.project.passer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EventObject;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class reCAPTCHA {

    public TextField TF;
    public Label label;
    public Button btn;

    public void initialize () throws IOException {
        URL url = new URL("https://api.quotable.io/random");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        //System.out.println(connection.getResponseCode());

        String[] data = new String[0];
        if (connection.getResponseCode() == 200) {
            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                informationString.append(scanner.nextLine());
            }
            //Close the scanner
            scanner.close();

            //System.out.println(informationString);

            data = informationString.toString().split("\"");

//            for (String a : data)
//                System.out.println(a);

            //index needed = 11
        }

        String[] tmp = data[11].split(" ");
        label.setText(tmp[0]);

    }

    public void verify(ActionEvent actionEvent) throws ExecutionException, InterruptedException {
        if (label.getText().toUpperCase().equals(TF.getText().toUpperCase())){
            Stage thisStage = (Stage)((Node)((EventObject) actionEvent).getSource()).getScene().getWindow();
            thisStage.hide();



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
            //FirebaseApp.initializeApp(options);
            Firestore db = FirestoreClient.getFirestore();


            DocumentReference docRef = db.collection("staff").document(passer.passedID);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = null;
            document = future.get();

            if ( document.exists() ) {
                ApiFuture<WriteResult> writeResult = db.collection("staff").document(passer.passedID).delete();

                Manager.GetManager().Remove(Integer.parseInt(passer.passedID));
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("ID not Found!!");
                alert.show();
            }


        }
    }
}
