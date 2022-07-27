package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Model;

public class homeScreenController {

    @FXML
    Label greeting;

    public void displayText(ActionEvent action) {
        greeting.setText(Model.getGreeting());
    }

//      need to create methods
//     public void addToOrder(ActionEvent action){
   
//     }
 }
