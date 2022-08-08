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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Shoes;
import model.User;
import utilities.Csv;

public class SearchScreenController {

	private User curUser;
	// private ArrayList<Shoes> results;

    @FXML
    ListView<String> results;

    @FXML
    TextField userSearch;

    public void updateUser(User user) {
    	curUser = user;
    }

    // public void switchScreen(ActionEvent action) throws IOException{
    //     FXMLLoader loader = new FXMLLoader();
    //     loader.setLocation(getClass().getResource("/view/itemDetailsScreen.fxml"));
    //     Parent root = loader.load();
    //     Scene scene = new Scene(root);
    //     itemDetailsScreenController controller = loader.getController(); 
    //     controller.updateInfo(curUser);
    //     Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
    //     stage.setScene(scene);
    //     stage.show();
    // }

    public void search(ActionEvent action) throws IOException{
        // remove current search results
        results.getItems().clear();

        String searchTerm = userSearch.getText();
        ArrayList<Shoes> shoes = Csv.getShoesFromCsv();

        // every time a shoe matches the search
        // add it to found shoes
        for (Shoes shoeToSearch : shoes) {
            // if the name matches, add it to found shoes
            if (searchTerm.equals(shoeToSearch.getModel())){
                results.getItems().add(shoeToSearch.getModel());
            }
            // if the name starts with the search term, add it to found shoes
            if (shoeToSearch.getModel().startsWith(searchTerm)){
                results.getItems().add(shoeToSearch.getModel());
            }
            // if the barcode matches, add it to found shoes
            if (shoeToSearch.getBarcode().equals(searchTerm)){
                results.getItems().add(shoeToSearch.getModel());
            }
            // if the color matches, add it to found shoes
            if (shoeToSearch.getColor().equals(searchTerm)){
                results.getItems().add(shoeToSearch.getModel());
            }
        }

        // what to do with found shoes?
        // send them to the view!

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
