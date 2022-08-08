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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class itemDetailsScreenController {

	private User curUser;
	
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

    public void updateInfo(User user) {
    	curUser = user;
    	stock.setText("Pairs In Stock: " + Integer.toString(curUser.getCurrent().getStock()));
    	size.setText("Size: " + curUser.getCurrent().getSize());
    	color.setText("Color: " + curUser.getCurrent().getColor());
    	price.setText("Price: " + curUser.getCurrent().getPrice());
    	model.setText("Model: " + curUser.getCurrent().getModel());
    	barcode.setText("Barcode: " + curUser.getCurrent().getBarcode());
    	Image image;
		try {
			image = new Image(new FileInputStream(curUser.getCurrent().getImageURL()));
			shoeImage.setImage(image);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FINDING SHOE IMAGE");
		}
		if(user.getCurrent().getStock() <= 0) {
			orderButton.setVisible(false);
		}
    }
    
    public void addToOrder(ActionEvent action) {
        curUser.addToCart(curUser.getCurrent());
        updateInfo(curUser);
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
    
    public void goToHome(MouseEvent event) throws IOException {
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
