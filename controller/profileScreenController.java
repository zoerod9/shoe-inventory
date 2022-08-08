package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Shoes;
import model.User;

public class ProfileScreenController {
    private User curUser;
	
    @FXML
    private Text userNameText;
    @FXML
    private TextArea cartText;
    @FXML
    private Button logOutButton;
    @FXML
    private ImageView homeButton;
    @FXML
    private TextArea inventoryText;
    
    public void updateInfo(User user) {
    	curUser = user;
    	userNameText.setText("Username: " + curUser.getUserName());
    	inventoryText.setText("Inventory: " + curUser.getInventory().toString());
    	cartText.setText("Current Cart: \n" + curUser.getCart().toString());
    }
    
    public void logOutUser(MouseEvent event) throws IOException {
    	this.curUser = null;
    	Parent root = FXMLLoader.load(getClass().getResource("/view/logInScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
    }
    
    public void goToHome(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/homeScreen.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        HomeScreenController controller = loader.getController(); 
        controller.updateUser(curUser);
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
}
