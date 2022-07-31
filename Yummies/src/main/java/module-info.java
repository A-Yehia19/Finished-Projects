module yummies.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires java.sql;

    requires com.google.auth.oauth2;
    requires com.google.auth;
    requires google.cloud.core;
    requires firebase.admin;
    requires google.cloud.firestore;
    requires com.google.api.apicommon;
    requires javafx.media;

    exports yummies.project;
    exports yummies.project.Controllers;
    opens yummies.project to javafx.fxml;
    opens yummies.project.Controllers to javafx.fxml;
}