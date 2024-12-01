package com.tyc.collectionintersection.controller;


import com.tyc.collectionintersection.services.IntersectionService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class IntersectionController {

    private int maxValue = 0;
    private int sizeA = 0;
    private int sizeB = 0;
    private IntersectionService intersectionService;

    @FXML private TextField sizeTextFieldA;
    @FXML private TextField sizeTextFieldB;
    @FXML private TextField maxValueTextField;
        
    @FXML private Label sizeOfIntersectionLabel;
    @FXML private Label timeToCalculateLabel;
    @FXML private Label errorLabel;

    @FXML private ComboBox<String> optionComboBox;

    @FXML private Button runButton;

    @FXML
    private void initialize() {
        // Set default values for the text fields
        sizeTextFieldA.setText("100");
        sizeTextFieldB.setText("10000");
        maxValueTextField.setText("65535");

        // Set the action for the run button
        runButton.setOnAction(event -> onRunButtonClick());
    }

    protected boolean validateInputs() {
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

    protected void onRunButtonClick() {
        errorLabel.setText("");
        if (!validateInputs()) {
            return;
        }

        this.intersectionService = new IntersectionService(sizeA, sizeB, maxValue, optionComboBox.getValue().equals("A"));
        sizeOfIntersectionLabel.setText("Intersection size: " + this.intersectionService.getIntersectionSize());
        timeToCalculateLabel.setText("Time to calculate intersection: " + this.intersectionService.getTimeToCalculateIntersection() + " nanoseconds");
    }
}
