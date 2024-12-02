package com.tyc.collectionintersection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.testfx.api.FxAssert;


@ExtendWith(ApplicationExtension.class)
public class IntersectionApplicationTest {

    @Start
    public void onStart(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tyc/collectionintersection/intersection-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Collection Intersection");
        stage.show();
    }

    @Test
    public void testRunButton(FxRobot robot) {
        // Check that the text fields have the correct initial values
        FxAssert.verifyThat("#sizeTextFieldA", (TextField field) -> 
            field.getText().equals("100")
        );
        FxAssert.verifyThat("#sizeTextFieldB", (TextField field) -> 
            field.getText().equals("10000")
        );
        FxAssert.verifyThat("#upperBoundTextField", (TextField field) -> 
            field.getText().equals("65535")
        );
        FxAssert.verifyThat("#optionComboBox", (ComboBox<String> comboBox) -> 
            comboBox.getValue().equals("A")
        );

        // Click the Run button
        robot.clickOn("Run");
    	robot.sleep(1000);

        FxAssert.verifyThat("#sizeOfIntersectionLabel", (Label label) -> 
            label.getText().startsWith("Intersection size")
        );
        FxAssert.verifyThat("#timeToCalculateLabel", (Label label) -> 
            label.getText().startsWith("Time to calculate")
        );
    }

    @Test
    public void testUpdateInputsAndRun(FxRobot robot) {
        robot.clickOn("#sizeTextFieldA");
        robot.eraseText(3);
        robot.write("300x");

        robot.clickOn("#optionComboBox");
        robot.clickOn("B");
        robot.clickOn("#runButton");

        FxAssert.verifyThat("#errorLabel", (Label label) -> 
            label.getText().equals("Please enter valid collection sizes, they must be numbers greater than 0.")
        );

        robot.clickOn("#sizeTextFieldA");
        robot.eraseText(1);

        robot.clickOn("#runButton");

        FxAssert.verifyThat("#errorLabel", (Label label) -> 
            label.getText().isEmpty()
        );

        FxAssert.verifyThat("#sizeOfIntersectionLabel", (Label label) -> 
            label.getText().startsWith("Intersection size")
        );
    }
}
