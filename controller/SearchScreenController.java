package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Shoes;
import model.User;

public class SearchScreenController {

	private User curUser;
	private ArrayList<Shoes> results;
	
    @FXML
    TextArea result1;
    @FXML
    TextArea result2;
    @FXML
    TextArea result3;
    @FXML
    TextArea result4;

    public void updateUser(User user) {
    	curUser = user;
    }

    public void switchScreen(ActionEvent action) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/itemDetailsScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        itemDetailsScreenController controller = loader.getController(); 
        controller.updateInfo(curUser);
        Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void goToHome(MouseEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        homeScreenController controller = loader.getController(); 
        controller.updateUser(curUser);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void viewDetails(MouseEvent event) {
		String id = ((Button)event.getSource()).getId();
		if(id.equals("detailsOne")) {
			System.out.println("Working");
			//curUser.setCurrent();
		}
    }
    
    public void goToCart(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/orderScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        OrderScreenController controller = loader.getController(); 
        controller.updateUser(curUser);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void goToProfile(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/profileScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        profileScreenController controller = loader.getController(); 
        controller.updateInfo(curUser);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
