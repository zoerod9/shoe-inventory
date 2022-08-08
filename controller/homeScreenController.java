package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Shoes;
import model.User;
import utilities.Csv;

public class HomeScreenController {

	private User curUser;

    @FXML
    ListView<String> toCheckIn = new ListView<>();
    ArrayList<Shoes> internalToCheckIn = new ArrayList<>();
    
    public void updateUser(User user) {
    	curUser = user;
    }

    public void initialize(){
        toCheckIn.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    // public void switchToInventory(ActionEvent event) throws IOException {
    // 	FXMLLoader loader = new FXMLLoader();
    //     loader.setLocation(getClass().getResource("/view/inventoryAddScreen.fxml"));
    //     Parent root = loader.load();
    //     Scene scene = new Scene(root);
    //     inventoryAddScreenController controller = loader.getController(); 
    //     controller.updateUser(curUser);
    //     Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    //     stage.setScene(scene);
    //     stage.show();
    // }

    public void addToInventory(ActionEvent event) throws IOException {
        ObservableList<Integer> selectedIndices = toCheckIn.getSelectionModel().getSelectedIndices();

        selectedIndices.forEach((selectedIndex) -> {
            Shoes selectedShoes = internalToCheckIn.get(selectedIndex);
            Csv.checkInShoes(selectedShoes);
        });
    }

    public void switchToOrderScreen(ActionEvent event) throws IOException {
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

    public void switchToSearchScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/searchScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SearchScreenController controller = loader.getController(); 
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
        ProfileScreenController controller = loader.getController(); 
        controller.updateInfo(curUser);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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

    public void setToCheckIn(ArrayList<Shoes> uncheckedShoes){
        this.internalToCheckIn = uncheckedShoes;
        ArrayList<String> toCheckInStrings = new ArrayList<>();
        for (Shoes shoe : uncheckedShoes) {
            toCheckInStrings.add(shoe.getModel());
        }

        toCheckIn.getItems().addAll(toCheckInStrings);
    }
}
