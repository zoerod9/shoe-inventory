package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

/**
 * ItemDetailsScreenController is the controller class for the item details
 * screen and contains all the
 * necessary methods for the item detail screen to run and be able to perform
 * its functions and switch
 * to other screens. This class will also have methods that will add items to
 * the cart.
 * 
 * @authors Zoe Rodriguez (vcd011), Enrique Mata (rre165), William El Haber
 *          (csn639)
 *          UTSA CS 3443 - shoe-inventory Team Project
 *          Summer 2022
 */

public class ItemDetailsScreenController {

    // This is the user object that will keep track of the shoes from class to class
    // and screen to screen
    private User curUser;

    // The variables from the FXML file that will be utilized in methods.
    @FXML
    private ImageView shoeImage;
    @FXML
    private Button orderButton;
    @FXML
    private Text stock;
    @FXML
    private Text size;
    @FXML
    private Text color;
    @FXML
    private Text price;
    @FXML
    private Text model;
    @FXML
    private Text barcode;
    @FXML
    private ImageView profileButton;
    @FXML
    private ImageView homeButton;

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
    public void updateInfo(User user) {
        // Creates new user and sets its information to the passed in user
        curUser = new User("", "");
        curUser.setCart(user.getCart());
        curUser.setCurrent(user.getCurrent());
        curUser.setInventory(user.getInventory());
        // Will determine the stock based on what is in the cart as well
        String tempStock = Integer.toString(curUser.getCurrent().getStock());
        for (int i = 0; i < curUser.getCart().size(); i++) {
            if (curUser.getCart().get(i).getBarcode().equals(curUser.getCurrent().getBarcode())) {
                tempStock = Integer.toString(curUser.getCurrent().getStock() - curUser.getCart().get(i).getStock());
            }
        }
        // Updates text on the screen
        stock.setText("Pairs In Stock: " + tempStock);
        size.setText("Size: " + curUser.getCurrent().getSize());
        color.setText("Color: " + curUser.getCurrent().getColor());
        price.setText("Price: " + curUser.getCurrent().getPrice());
        model.setText("Model: " + curUser.getCurrent().getModel());
        barcode.setText("Barcode: " + curUser.getCurrent().getBarcode());
        // Attempts to load image will print to the console if it is not able to be
        // found.
        Image image;
        try {
            image = new Image(new FileInputStream("src/" + curUser.getCurrent().getImageURL()));
            shoeImage.setImage(image);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        // If the stock is less than or equal to 0 than the add to order button is
        // hidden since it should
        // not be added to the cart anymore.
        if (user.getCurrent().getStock() <= 0) {
            orderButton.setVisible(false);
        }
    }

    /*
     * addToOrder takes will run when the correct button is pressed and will add the
     * shoe currently displaying to the cart of the user
     * 
     * @param event: This lets the program know that the user has clicked the
     * button and to add to the cart
     * 
     * @return No returns but curUser has it's cart updated with a new shoe of the
     * current
     * shoe displayed.
     */
    public void addToOrder(ActionEvent action) {
        curUser.addToCart(curUser.getCurrent());
        updateInfo(curUser);
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
        controller.updateUser(curUser); // This line will update information for the new screen
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
}
