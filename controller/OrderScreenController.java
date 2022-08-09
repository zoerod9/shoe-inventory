package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Csv;
import model.Shoes;
import model.User;
import javafx.scene.Scene;

/**
 * OrderScreenController is the controller class for the order screen and contains all the necessary methods
 * for the order screen to run and be able to perform its functions and switch to other screens. This class
 * will also be able to display information about the cart and the current order.
 * 
 * @authors Zoe Rodriguez (vcd011), Enrique Mata (rre165), William El Haber (csn639)
 * UTSA CS 3443 - shoe-inventory Team Project
 * Summer 2022
 */

public class OrderScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private User curUser;

    // Variables from the FXML that will be utilized by the class in methods.
    @FXML
    TextArea orderText;
    @FXML
    Text totalText;

    /*
     * updateInfo takes in a User object and creates a new object with that user's
     * information essentially passing the information from one user to anther and one class to
     * another. This will also update the text on the screen with the necessary information
     * from the user.
     * @param user: The User who is currently using this program and will be moved to
     * the new screen and who's information will be used to fill the text on the screen.
     * @return No returns but curUser is updated with values from user and the text on
     * screen is updated.
     */
    public void updateUser(User user) {
        curUser = new User("", "");
        curUser.setCart(user.getCart());
        curUser.setCurrent(user.getCurrent());
        curUser.setInventory(user.getInventory());
        // Will display the cart or if the cart is empty will display that it is empty.
        String tempCartText = "";
        for (int i = 0; i < curUser.getCart().size(); i++) {
            tempCartText = tempCartText + " " + curUser.getCart().get(i).toString();
        }
        if (tempCartText.equals(""))
            tempCartText = "CART IS EMPTY";
        orderText.setText(tempCartText);
        // Will calculate the total cost of the current order.
        int total = 0;
        for (int i = 0; i < curUser.getCart().size(); i++) {
            total += Integer.parseInt(curUser.getCart().get(i).getPrice()) * curUser.getCart().get(i).getStock();
        }
        totalText.setText("Total: $" + Integer.toString(total));
    }

    /*
     * switchToSearchScreen will switch the scene to the search screen when the user
     * presses on the proper button.
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the search screen.
     * @return No return but will update the curUser of the new class with this curUser and
     * will update information on that screen then will change to that screen.
     */
    public void switchToSearchScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/searchScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SearchScreenController controller = loader.getController();
        controller.updateUser(curUser); // This line will update information for the new screen
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /*
     * goHome will switch the scene to the home screen when the user presses on the
     * proper button.
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the home screen.
     * @return No return but will update the curUser of the new class with this curUser and
     * will update information on that screen then will change to that screen.
     */
    public void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HomeScreenController controller = loader.getController();
        controller.updateUser(curUser); // This line will update information for the new screen
        ArrayList<Shoes> uncheckedShoes = Csv.getShoesToCheckInFromCsv();
        controller.setToCheckIn(uncheckedShoes);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /*
     * goToProfile will switch the scene to the profile screen when the user presses
     * on the proper button.
     * @param event: The event that occurred which lets the program know that
     * the user wants to change to the profile screen.
     * @return No return but will update the curUser of the new class with this curUser and
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

    /*
     * NOT WORKING YET TEMPORARY FUNCTION
     * placeOrder will update the stock in the csv file and will place the order.
     * @param event: The event that occurred which lets the program know that
     * the user wants to place the order of the current cart.
     * @return No return but will update the csv file and the stock and will place the order
     * in the cart.
     */
    public void placeOrder(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("Sucess!");
        alert.setHeaderText("Your order has been placed");
        alert.show();
    }
}
