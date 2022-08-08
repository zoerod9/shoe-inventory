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
import javafx.stage.Stage;
import model.Shoes;
import model.User;
import utilities.Csv;

public class HomeScreenController {

	//User object that will be used to pass information between controllers and screens
	private User curUser = new User("", "");

	//List of shoes to be checked in on the screen and the internal list as well
    @FXML
    ListView<String> toCheckIn = new ListView<>();
    ArrayList<Shoes> internalToCheckIn = new ArrayList<>();
    
    /*
     * updateUser takes in a User object and creates a new object with that user's information
     * essentially passing the information from one user to anther and one class to another 
     * Parameters: 
     * User user: The User who is currently using this program and will be moved to the new screen
     * Returns:
     * No returns but curUser is updated with values from user
     */
    public void updateUser(User user) {
    	curUser = new User("", "");
    	curUser.setCart(user.getCart());
    	curUser.setCurrent(user.getCurrent());
    	curUser.setInventory(user.getInventory());
    }

    /*
     * Initializes toCheckIn to allow it to be utilized and for shoes to be properly added.
     * Parameters: 
     * No parameters
     * Returns:
     * No returns
     */
    public void initialize(){
        toCheckIn.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    //Contains code for a scence that was not utilized.
    
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

    /*
     * addToInventory runs when a shoe is selected from the incoming inventory to be added to the
     * current inventory and the check in button is selected.
     * Parameters: 
     * ActionEvent event: The event that occurred which lets the program know that the user wants to
     * check in shoes.
     * Returns:
     * No return but will update the Inventory with the newly checked in shoes.
     */
    public void addToInventory(ActionEvent event) throws IOException {
        ObservableList<Integer> selectedIndices = toCheckIn.getSelectionModel().getSelectedIndices();

        selectedIndices.forEach((selectedIndex) -> {
            Shoes selectedShoes = internalToCheckIn.get(selectedIndex);
            Csv.checkInShoes(selectedShoes);
        });
    }

    /*
     * switchToOrderScreen will switch the scene to the order screen when the user presses on the
     * proper button.
     * Parameters: 
     * ActionEvent event: The event that occurred which lets the program know that the user wants to
     * change to the order screen.
     * Returns:
     * No return but will update the curUser of the new class with this curUser and will update
     * information on that screen then will change to that screen.
     */
    public void switchToOrderScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/orderScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        OrderScreenController controller = loader.getController(); 
        controller.updateUser(curUser); //This line will update information for the new screen
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /*
     * switchToSearchScreen will switch the scene to the search screen when the user presses on the
     * proper button.
     * Parameters: 
     * ActionEvent event: The event that occurred which lets the program know that the user wants to
     * change to the search screen.
     * Returns:
     * No return but will update the curUser of the new class with this curUser and will update
     * information on that screen then will change to that screen.
     */
    public void switchToSearchScreen(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/searchScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SearchScreenController controller = loader.getController(); 
        controller.updateUser(curUser); //This line will update information for the new screen
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    /*
     * goToProfile will switch the scene to the profile screen when the user presses on the
     * proper button.
     * Parameters: 
     * ActionEvent event: The event that occurred which lets the program know that the user wants to
     * change to the profile screen.
     * Returns:
     * No return but will update the curUser of the new class with this curUser and will update
     * information on that screen then will change to that screen.
     */
    public void goToProfile(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/profileScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        ProfileScreenController controller = loader.getController(); 
        controller.updateInfo(curUser); //This line will update information for the new screen
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    /*
     * setToCheckIn will take in the uncheckedShoes and set the internal array to the passed in
     * array. It will then add the shoes that are in uncheckedShoes by their model to the List on the
     * screen.
     * Parameters:
     * ArrayList<Shoes> uncheckedShoes: An ArrayList of shoes that will be added to the List on the screen
     * and displayed so the User can select which shoes should be added.
     * Returns:
     * No return but will update the screen with the information passed in.
     */
    public void setToCheckIn(ArrayList<Shoes> uncheckedShoes){
        this.internalToCheckIn = uncheckedShoes;
        ArrayList<String> toCheckInStrings = new ArrayList<>();
        for (Shoes shoe : uncheckedShoes) {
            toCheckInStrings.add(shoe.getModel());
        }

        toCheckIn.getItems().addAll(toCheckInStrings);
    }
}
