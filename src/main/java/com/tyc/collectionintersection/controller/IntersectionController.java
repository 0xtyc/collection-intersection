package com.tyc.collectionintersection.controller;


import com.tyc.collectionintersection.services.IntersectionService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class IntersectionController {

    private final String INVALID_COLLECTION_SIZE_MESSAGE = "Please enter valid collection sizes, they must be numbers greater than 0.";
    private final String INVALID_UPPER_BOUND_MESSAGE = "Please enter a valid upper bound, it must be a number greater than the size of both collections.";

    private int sizeA = 0;
    private int sizeB = 0;
    private int upperBound = 0;
    private IntersectionService intersectionService;

    @FXML
    private TextField sizeTextFieldA;

    @FXML
    private TextField sizeTextFieldB;

    @FXML
    private TextField upperBoundTextField;
        
    @FXML
    private Label sizeOfIntersectionLabel;

    @FXML
    private Label timeToCalculateLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private ComboBox<String> optionComboBox;

    @FXML
    private Button runButton;

    @FXML
    private void initialize() {
        // Set default values for the text fields
        sizeTextFieldA.setText("100");
        sizeTextFieldB.setText("10000");
        upperBoundTextField.setText("65535");
        optionComboBox.getItems().addAll("A", "B");
        optionComboBox.setValue("A");
        // Set the action for the run button
        runButton.setOnAction(event -> onRunButtonClick());
    }

    // getter for unit testing
    int getSizeA() {
        return sizeA;
    }

    // getter for unit testing
    int getSizeB() {
        return sizeB;
    }
    
    // package private for unit testing
    boolean validateCollectionSize(String sizeStringA, String sizeStringB) {
        int parsedSizeA = 0;
        int parsedSizeB = 0;
        try {
            parsedSizeA = Integer.parseInt(sizeStringA);
            parsedSizeB = Integer.parseInt(sizeStringB);
        } catch (NumberFormatException e) {
            return false;
        }
        if (parsedSizeA <= 0 || parsedSizeB <= 0) {
            return false;
        }
        this.sizeA = parsedSizeA;
        this.sizeB = parsedSizeB;
        return true;
    }

    // package private for unit testing
    boolean validateUpperBound(String upperBoundString) {
        int parsedUpperBound = 0;
        try {
            parsedUpperBound = Integer.parseInt(upperBoundString);
        } catch (NumberFormatException e) {
            return false;
        }
        if (parsedUpperBound <= 0 || parsedUpperBound < this.getSizeA() || parsedUpperBound < this.getSizeB()) {
            return false;
        }
        this.upperBound = parsedUpperBound;
        return true;
    }

    private void onRunButtonClick() {
        errorLabel.setText("");

        if (!validateCollectionSize(sizeTextFieldA.getText(), sizeTextFieldB.getText())) {
            errorLabel.setText(INVALID_COLLECTION_SIZE_MESSAGE);
            return;
        }
        if (!validateUpperBound(upperBoundTextField.getText())) {
            errorLabel.setText(INVALID_UPPER_BOUND_MESSAGE);
            return;
        }

        this.intersectionService = new IntersectionService(this.sizeA, this.sizeB, this.upperBound, optionComboBox.getValue().equals("A"));
        sizeOfIntersectionLabel.setText("Intersection size: " + this.intersectionService.calculateIntersectionSize());
        timeToCalculateLabel.setText("Time to calculate intersection: " + this.intersectionService.benchmarkIntersectionCalculation() + " nanoseconds");
    }
}
