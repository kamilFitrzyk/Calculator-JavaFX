package org.javastart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private String operator = "";
    private double number1 = 0.0;

    @FXML
    private Pane mainPane;

    @FXML
    private Pane titlePane;

    @FXML
    private TextField resultField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane) event.getSource()).getId().replace("bnt", ""));
        if (resultField.getText().equals("0")) {
            resultField.setText(value + "");
        } else {
            resultField.setText(resultField.getText() + value);
        }

    }

    @FXML
    private void onClearClicked(MouseEvent event) {
        resultField.setText("0");
        operator = "";
    }

    @FXML
    private void onOperationClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("bnt", "");
        switch (symbol) {
            case "Plus":
                operator = "+";
                break;
            case "Minus":
                operator = "-";
                break;
            case "Multiply":
                operator = "*";
                break;
            case "Divide":
                operator = "/";
                break;
        }
        number1 = Double.parseDouble(resultField.getText());
        resultField.setText("0");
    }

    @FXML
    private void onEqualsClicked(MouseEvent event) {
        double number2 = Double.parseDouble(resultField.getText());
        switch (operator) {
            case "+":
                resultField.setText((number1 + number2) + "");
                break;
            case "-":
                resultField.setText((number1 - number2) + "");
                break;
            case "*":
                resultField.setText((number1 * number2) + "");
                break;
            case "/":
                if (number2 != 0 ) {
                    resultField.setText((number1 / number2) + "");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Divide by zero!");
                    alert.show();
                }

                break;
        }
        operator = "";
    }

    @FXML
    public void onDotClicked(MouseEvent event) {
        String text = resultField.getText();

        if (!text.contains(".") && !text.isEmpty()) {
            resultField.setText(resultField.getText() + ".");
        } else if (text.isEmpty()) {
            resultField.setText("0.");
        }
    }




}
