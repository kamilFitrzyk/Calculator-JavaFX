package org.javastart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private String operator = "";
    private Double number1 = 0.0;

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
        //System.out.println(value);
        String text = resultField.getText();
        resultField.setText(text + value);
    }

    @FXML
    private void onClearClicked(MouseEvent event) {
        resultField.setText("");
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
        resultField.setText("");
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
                resultField.setText((number1 / number2) + "");
                break;
        }
        operator = "";
    }




}
