package controller;

import javafx.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Csv;
import model.Shoes;
import model.User;

/**
 * ProfileScreenController is the controller class for the profile screen and
 * contains all the necessary methods
 * for the order screen to run and be able to perform its functions and switch
 * to other screens. This class
 * will also be able to display information about the cart and the inventory.
 * 
 * @authors Zoe Rodriguez (vcd011), Enrique Mata (rre165), William El Haber
 *          (csn639)
 *          UTSA CS 3443 - shoe-inventory Team Project
 *          Summer 2022
 */

public class ProfileScreenController {

    // This is the user object that will keep track of the shoes from class to class
    // and screen to screen
    private User curUser;

    // Variables from the FXML that will be utilized by the class in methods.
    @FXML
    private Text userNameText;
    @FXML
    private TextArea cartText;
    @FXML
    private TextArea inventoryText;
    @FXML
    private Button homeButton;

    /*
     * updateInfo takes in a User object and creates a new object with that user's
     * information essentially passing the information from one user to anther and
     * one class to
     * another. This will also update the text on the screen with the necessary
     * information
     * from the user.
     * 
     * @param user: The User who is currently using this program and will be moved
     * to
     * the new screen and who's information will be used to fill the text on the
     * screen.
     * 
     * @return No returns but curUser is updated with values from user and the text
     * on
     * screen is updated.
     */
    public void updateInfo(User user) throws FileNotFoundException {
        curUser = new User("", "");
        // Gets inventory from the Csv file.
        ArrayList<Shoes> inventory = Csv.getShoesFromCsv();
        curUser.setCart(user.getCart());
        curUser.setCurrent(user.getCurrent());
        curUser.setInventory(inventory);
        // Changes the text to the proper inventory and cart of the user but if either
        // is empty it will
        // print that the value is empty.
        String invText = "";
        for (int i = 0; i < curUser.getInventory().size(); i++) {
            invText = invText + " " + curUser.getInventory().get(i).toString();
        }
        if (invText.equals("")) {
            invText = "INVENTORY IS EMPTY";
        }

        inventoryText.setText("Inventory: " + invText);
        String tempCartText = "";
        for (int i = 0; i < curUser.getCart().size(); i++) {
            tempCartText = tempCartText + " " + curUser.getCart().get(i).toString();
        }
        if (tempCartText.equals("")) {
            tempCartText = "CART IS EMPTY";
        }

        cartText.setText("Current Cart: \n" + tempCartText);
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
     * goHome will switch the scene to the home screen when the user presses on the
     * proper button.
     * 
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the home screen.
     * 
     * @return No return but will update the curUser of the new class with this
     * curUser and
     * will update information on that screen then will change to that screen.
     */
    public void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HomeScreenController controller = loader.getController();
        controller.updateUser(curUser);
        ArrayList<Shoes> uncheckedShoes = Csv.getShoesToCheckInFromCsv();
        controller.setToCheckIn(uncheckedShoes);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
