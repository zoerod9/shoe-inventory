package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Model;

public class itemDetailsScreenController {

    @FXML
    ImageView shoeImage;
    Button orderButton;
    Text stock;
    Text itemDescription;
    Text size;
    Text color;
    Text price;
    Text model;
    Text barcode;
    ImageView profileButton;
    ImageView homeButton;

    public void updateInfo(Shoes current) {
    	stock.setText(current.getStock());
    	itemDescription.setText(current.getItemDescription());
    	size.setText(current.getSize());
    	color.setText(current.getColor());
    	price.setText(current.getPrice());
    	model.setText(current.getModel());
    	barcode.setText(current.getBarcode());
    	Image image = new Image(new FileInputStream(current.getImageURL()));
    	shoeImage.setImage(image);
    }
    
    public void addToOrder(ActionEvent action) {
    	User curUser = getCurrentUser();
        curUser.addToCart(curUser.getCurrent());
    }
    
    public void goToProfile(MouseEvent event) {
        Parent root = FXMLLoader.load(getClass().getResource("/view/.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
    }
    
    public void goToHome(MouseEvent event) {
    	Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
    }
}
