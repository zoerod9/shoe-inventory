package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Model;

import javafx.scene.Scene;

public class OrderScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label greeting;

    public void displayText(ActionEvent event) {
        greeting.setText(Model.getGreeting());
    }

    public void switchToSearchScreen(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/view/searchScreen.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root); 
         stage.setScene(scene);
         stage.show();

    }
    public void goToHome(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();
        
    }
}
