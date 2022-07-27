package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Model;

public class homeScreenController {

    @FXML
    Label greeting;

    public void displayText(ActionEvent action) {
        greeting.setText(Model.getGreeting());
    }

    public void switchToOrderScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/orderScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 800); 
        stage.setScene(scene);
        stage.show();

   }

   public void switchToSearchScreen(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/searchScreen.fxml"));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root, 800, 800); 
    stage.setScene(scene);
    stage.show();

}
 }
