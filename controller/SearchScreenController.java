package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Model;

public class SearchScreenController {

    @FXML
    Label greeting;

    public void displayText(ActionEvent action) {
        greeting.setText(Model.getGreeting());
    }

    // public void addToOrder(ActionEvent action){
        
    // }
}
