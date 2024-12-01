package com.tyc.collectionintersection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IntersectionApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(IntersectionApplication.class.getResource("intersection-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 360, 480);
            stage.setTitle("Collection Intersection");
            stage.setScene(scene);
            stage.show();
        } catch (javafx.fxml.LoadException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for more details
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
