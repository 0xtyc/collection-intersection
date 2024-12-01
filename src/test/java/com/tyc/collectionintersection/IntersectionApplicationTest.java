package com.tyc.collectionintersection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.TextInputControlMatchers;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    	
        // Verify that the text fields have the expected default values
        FxAssert.verifyThat("#sizeTextFieldA", TextInputControlMatchers.hasText("100"));
        FxAssert.verifyThat("#sizeTextFieldB", TextInputControlMatchers.hasText("10000"));
        FxAssert.verifyThat("#upperBoundTextField", TextInputControlMatchers.hasText("65535"));
        
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
    public void testInvalidInputs(FxRobot robot) {
        robot.clickOn("#sizeTextFieldA").write("x");
        robot.clickOn("Run");
        FxAssert.verifyThat("#errorLabel", (Label label) -> 
            label.getText().equals("Please enter valid numbers for all fields")
        );
    }
}
