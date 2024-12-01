module com.tyc.collectionintersection {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tyc.collectionintersection;
    opens com.tyc.collectionintersection.controller to javafx.fxml;

    exports com.tyc.collectionintersection;
    exports com.tyc.collectionintersection.controller;
    exports com.tyc.collectionintersection.services;
    exports com.tyc.collectionintersection.utils;
}