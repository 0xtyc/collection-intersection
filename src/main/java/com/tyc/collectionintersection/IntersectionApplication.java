package com.tyc.collectionintersection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IntersectionApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IntersectionApplication.class.getResource("intersection-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 480);
        stage.setTitle("Collection Intersection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
