package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Model;

public class Controller {

    @FXML
    Label greeting;

    public void displayText(ActionEvent action) {
        greeting.setText(Model.getGreeting());
    }
}
