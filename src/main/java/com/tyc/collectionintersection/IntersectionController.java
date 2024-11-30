package com.tyc.collectionintersection;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class IntersectionController {

   
    private IntersectionService intersectionService;

    private int maxValue = 0;
    private int sizeA = 0;
    private int sizeB = 0;

    @FXML
    private TextField sizeTextFieldA;

    @FXML
    private TextField sizeTextFieldB;

    @FXML
    private TextField maxValueTextField;

    @FXML
    private Label sizeOfIntersectionLabel;

    @FXML
    private Label timeToCalculateLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private ComboBox<String> optionComboBox;


    @FXML
    protected void onRunButtonClick() {
        errorLabel.setText("");
        if (!validateInputs()) {
            return;
        }

        this.intersectionService = new IntersectionService(sizeA, sizeB, maxValue, optionComboBox.getValue().equals("A"));
        sizeOfIntersectionLabel.setText("Intersection size: " + this.intersectionService.getIntersectionSize());
        timeToCalculateLabel.setText("Time to calculate intersection: " + this.intersectionService.getTimeToCalculateIntersection() + " nanoseconds");
    }

    private boolean validateInputs() {
        final String INVALID_INPUT_MESSAGE = "Please enter valid numbers for all fields";
        final String MAX_VALUE_ERROR_MESSAGE = "Max value must be greater than the size of both collections";
    
        try {
            maxValue = Integer.parseInt(maxValueTextField.getText());
            sizeA = Integer.parseInt(sizeTextFieldA.getText());
            sizeB = Integer.parseInt(sizeTextFieldB.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText(INVALID_INPUT_MESSAGE);
            return false;
        }

        if (maxValue <= 0 || sizeA <= 0 || sizeB <= 0) {
            errorLabel.setText(INVALID_INPUT_MESSAGE);
            return false;
        }
        if (maxValue < sizeA || maxValue < sizeB) {
            errorLabel.setText(MAX_VALUE_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
