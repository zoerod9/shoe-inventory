package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Csv;
import model.Shoes;
import model.User;

/**
 * SearchScreenController is the controller class for the search screen and
 * contains all the necessary methods
 * for the search screen to run and be able to perform its functions and switch
 * to other screens. This class
 * will also be able to search for shoes from the inventory.
 * 
 * @authors Zoe Rodriguez (vcd011), Enrique Mata (rre165), William El Haber
 *          (csn639)
 *          UTSA CS 3443 - shoe-inventory Team Project
 *          Summer 2022
 */

public class SearchScreenController {

    // This is the user object that will keep track of the shoes from class to class
    // and screen to screen
    private User curUser = new User("", "");

    // Variables for the lists of the results from the screen FXML file and the
    // internalResults array.
    @FXML
    ListView<String> results;
    ArrayList<Shoes> internalResults = new ArrayList<>();

    // Variable that contains the TextField containing userInput from the FXML file
    @FXML
    TextField userSearch;

    public void initialize() {
        try {
            internalResults = Csv.getShoesFromCsv();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Shoes shoe : internalResults) {
            results.getItems().add(shoe.getModel());
        }

    }

    /*
     * updateUser takes in a User object and creates a new object with that user's
     * information essentially passing the information from one user to anther and
     * one class to
     * another
     * 
     * @param user: The User who is currently using this program and will be moved
     * to
     * the new screen
     * 
     * @return No returns but curUser is updated with values from user
     */
    public void updateUser(User user) {
        curUser = new User("", "");
        curUser.setCart(user.getCart());
        curUser.setCurrent(user.getCurrent());
        curUser.setInventory(user.getInventory());
    }

    /*
     * navigateToItemDetailScreen will switch the scene to the item details screen
     * when the user presses on the shoes they want to view from the search.
     * 
     * @param action: The action that occurred which lets the program know that
     * the user wants to view more details about the searched shoe.
     * 
     * @return No return but will update what shoes were selected and will set the
     * current
     * shoe of user to the selected shoe update information and then switch scenes.
     */
    public void navigateToItemDetailScreen(MouseEvent action) throws IOException {
        int selected = results.getSelectionModel().getSelectedIndex();
        Shoes selectedShoes = internalResults.get(selected);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/itemDetailsScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        ItemDetailsScreenController controller = loader.getController();
        curUser.setCurrent(selectedShoes);
        controller.updateInfo(curUser); // This line will update information for the new screen
        Stage stage = (Stage) ((Node) action.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /*
     * search will search the inventory of shoes using the information provided by
     * the users to attempt to find any matches. If found they will display to the
     * screen and can
     * be selected to view more details.
     * 
     * @param action: This lets the program know that the user wishes to search
     * with the information they have typed in the search bar.
     * 
     * @return No returns but updates the screen with the shoes that were found to
     * match the
     * input.
     */
    public void search(ActionEvent action) throws IOException {
        // remove current search results
        results.getItems().clear();
        internalResults.clear();

        String searchTerm = userSearch.getText();
        ArrayList<Shoes> shoes = Csv.getShoesFromCsv();

        // every time a shoe matches the search
        // add it to found shoes
        for (Shoes shoeToSearch : shoes) {
            // if the name matches, add it to found shoes
            if (searchTerm.equalsIgnoreCase(shoeToSearch.getModel())) {
                results.getItems().add(shoeToSearch.getModel());
                internalResults.add(shoeToSearch);
            }
            // if the name starts with the search term, add it to found shoes
            if (shoeToSearch.getModel().toUpperCase().startsWith(searchTerm.toUpperCase())) {
                results.getItems().add(shoeToSearch.getModel());
                internalResults.add(shoeToSearch);
            }
            // if the barcode matches, add it to found shoes
            if (shoeToSearch.getBarcode().equalsIgnoreCase(searchTerm)) {
                results.getItems().add(shoeToSearch.getModel());
                internalResults.add(shoeToSearch);
            }
            // if the color matches, add it to found shoes
            if (shoeToSearch.getColor().equalsIgnoreCase(searchTerm)) {
                results.getItems().add(shoeToSearch.getModel());
                internalResults.add(shoeToSearch);
            }
        }

    }

    /*
     * goHome will switch the scene to the home screen when the user presses on the
     * proper button.
     * 
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the home screen.
     * 
     * @returns No return but will update the curUser of the new class with this
     * curUser and
     * will update information on that screen then will change to that screen.
     */
    public void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HomeScreenController controller = loader.getController();
        ArrayList<Shoes> uncheckedShoes = Csv.getShoesToCheckInFromCsv();
        controller.setToCheckIn(uncheckedShoes);
        controller.updateUser(curUser);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /*
     * goToCart will switch the scene to the order screen when the user presses on
     * the proper button.
     * 
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the order screen.
     * 
     * @return No return but will update the curUser of the new class with this
     * curUser and
     * will update information on that screen then will change to that screen.
     */
    public void goToCart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/orderScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        OrderScreenController controller = loader.getController();
        controller.updateUser(curUser); // This line will update information for the new screen
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /*
     * goToProfile will switch the scene to the profile screen when the user presses
     * on the proper button.
     * 
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the profile screen.
     * 
     * @return No return but will update the curUser of the new class with this
     * curUser and
     * will update information on that screen then will change to that screen.
     */
    public void goToProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/profileScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        ProfileScreenController controller = loader.getController();
        controller.updateInfo(curUser); // This line will update information for the new screen
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
