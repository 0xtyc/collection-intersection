module com.tyc.collectionintersection {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tyc.collectionintersection to javafx.fxml;
    exports com.tyc.collectionintersection;
}