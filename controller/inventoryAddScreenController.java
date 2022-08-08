package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Shoes;
import model.User;

public class InventoryAddScreenController {
    
	private User curUser;
	
	@FXML
	TextField sizeInput;
	@FXML
	TextField barcodeInput;
	@FXML
	TextField priceInput;
	@FXML
	TextField colorInput;
	@FXML
	TextField modelInput;
	@FXML
	TextField stockInput;
	@FXML
	TextField urlInput;
	@FXML
	Text messageText;
	
    public void updateUser(User user) {
    	curUser = user;
    }
    
    public void addToInventory(MouseEvent event) throws IOException {
        String size = sizeInput.getText();
        String barcode = barcodeInput.getText();
        String price = priceInput.getText();
        String color = colorInput.getText();
        String model = modelInput.getText();
        String stockTemp = stockInput.getText();
        int stock = 0;
        try {
            stock = Integer.parseInt(stockTemp);
        } catch (NumberFormatException nfe) {
            messageText.setText("Please enter a proper number for the stock!");
            return;
        }
        String url = urlInput.getText();
        Shoes temp = new Shoes(size, price, barcode, color, model, stock, url);
        curUser.addToInventory(temp);
        File input = new File("data/" + curUser.getUserName() + ".csv");
        FileWriter output = new FileWriter(input, true);
        output.write("\n" + size + "," + price + "," + barcode + "," + color + "," + model + "," + stock + "," + url);
        output.close();
        messageText.setText(model + " Added to inventory");
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
    
    public void goHome(MouseEvent event) throws IOException {
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
}
