package com.gloriane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {
    private TextField display = new TextField();
    private double firstNumber = 0;
    private String operation = "";
    private boolean newNumber = true;

    @Override
    public void start(Stage primaryStage) {
        display.setEditable(false);
        display.setPrefHeight(50);
        display.setStyle("-fx-font-size: 18px; -fx-alignment: center-right;");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        // Number buttons
        for (int i = 0; i <= 9; i++) {
            Button btn = createButton(String.valueOf(i));
            int row = 4 - (i - 1) / 3;
            int col = (i - 1) % 3;
            if (i == 0) { row = 5; col = 1; }
            grid.add(btn, col, row);
        }

        // Operation buttons
        grid.add(createButton("+"), 3, 2);
        grid.add(createButton("-"), 3, 3);
        grid.add(createButton("*"), 3, 4);
        grid.add(createButton("/"), 3, 5);
        grid.add(createButton("="), 2, 5);
        grid.add(createButton("C"), 0, 1);
        grid.add(createButton("."), 0, 5);

        // Advanced operations
        grid.add(createButton("^"), 1, 1);
        grid.add(createButton("√"), 2, 1);
        grid.add(createButton("!"), 3, 1);
        grid.add(createButton("ln"), 1, 5);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(display, grid);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button btn = new Button(text);
        btn.setPrefSize(60, 60);
        btn.setOnAction(e -> handleButton(text));
        return btn;
    }

    private void handleButton(String text) {
        try {
            switch (text) {
                case "C":
                    display.clear();
                    firstNumber = 0;
                    operation = "";
                    newNumber = true;
                    break;
                case "=":
                    calculate();
                    break;
                case "+": case "-": case "*": case "/": case "^":
                    if (!display.getText().isEmpty()) {
                        firstNumber = Double.parseDouble(display.getText());
                        operation = text;
                        newNumber = true;
                    }
                    break;
                case "√":
                    if (!display.getText().isEmpty()) {
                        double result = Calculator.sqrt(Double.parseDouble(display.getText()));
                        display.setText(String.valueOf(result));
                        newNumber = true;
                    }
                    break;
                case "!":
                    if (!display.getText().isEmpty()) {
                        long result = Calculator.factorial((int)Double.parseDouble(display.getText()));
                        display.setText(String.valueOf(result));
                        newNumber = true;
                    }
                    break;
                case "ln":
                    if (!display.getText().isEmpty()) {
                        double result = Calculator.log(Double.parseDouble(display.getText()));
                        display.setText(String.valueOf(result));
                        newNumber = true;
                    }
                    break;
                default:
                    if (newNumber) {
                        display.setText(text);
                        newNumber = false;
                    } else {
                        display.setText(display.getText() + text);
                    }
            }
        } catch (Exception e) {
            display.setText("Error");
            newNumber = true;
        }
    }

    private void calculate() {
        if (!operation.isEmpty() && !display.getText().isEmpty()) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operation) {
                case "+": result = firstNumber + secondNumber; break;
                case "-": result = firstNumber - secondNumber; break;
                case "*": result = firstNumber * secondNumber; break;
                case "/": result = firstNumber / secondNumber; break;
                case "^": result = Calculator.power(firstNumber, secondNumber); break;
            }

            display.setText(String.valueOf(result));
            operation = "";
            newNumber = true;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}