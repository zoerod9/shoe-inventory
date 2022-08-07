package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Shoes;
import model.User;

public class logInScreenController {
	
	private User curUser;
	
    @FXML
    private TextField usernameInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private Button logInButton;
    @FXML
    private Button newAccountButton;
    @FXML
    private Text passConfirm;
    @FXML
    private TextField passwordInputTwo;
    @FXML
    private Button registerAccount;
    @FXML
    private Button backButton;
    @FXML
    private Text messageText;

    private File input;
    
    public void logInMethod(MouseEvent event) throws IOException {
    	String userName = usernameInput.getText();
    	String password = passwordInput.getText();
        
    	File data = new File("data");
    	if(!data.exists()) {
    	    data.createNewFile();	
    	}
    	input = new File("data/" + userName + ".csv");
        if (input.exists()) {
            Scanner scanner = new Scanner(input);
            scanner.useDelimiter(",");
            String fileUser = scanner.next();
            String filePassword = scanner.next();
            if(fileUser.equals(userName) && filePassword.equals(password)) {
            	curUser = new User(userName, password);
            	if(scanner.hasNextLine())
            	    scanner.nextLine();
            	while(scanner.hasNextLine()) {
            		Scanner shoe = new Scanner(scanner.nextLine());
            		shoe.useDelimiter(",");
            		String size = shoe.next();
            		String price = shoe.next();
            		String barcode = shoe.next();
            		String color = shoe.next();
            		String model = shoe.next();
            		int stock = shoe.nextInt();
            		String url = shoe.next();
            		Shoes temp = new Shoes(size, price, barcode, color, model, stock, url);
            		curUser.addToInventory(temp);
            		curUser.setCurrent(curUser.getInventory().get(0));
            	}
            	scanner.close();
            	switchToHomeScreen(event);
            }
            else {
            	messageText.setText("That combination of username and password do not exist.");
            }
       	} 
       	else {
       	    messageText.setText("That username is not registered.");
       	}
    }
    
    public void switchToHomeScreen(MouseEvent event) throws IOException {
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
    
    public void createNewAccount(MouseEvent event) {
    	logInButton.setVisible(false);
    	newAccountButton.setVisible(false);
    	passConfirm.setVisible(true);
    	passwordInputTwo.setVisible(true);
    	registerAccount.setVisible(true);
    	backButton.setVisible(true);
    }
    
    public void registerNewAccount(MouseEvent event) throws IOException {
    	String userName = usernameInput.getText();
    	String password = passwordInput.getText();
    	String confirmPass = passwordInputTwo.getText();
    	File data = new File("data");
    	if(!data.exists()) {
    	    data.createNewFile();	
    	}
    	input = new File("data/" + userName + ".csv");
    	
    	if(userName.equals("") || password.equals("")|| confirmPass.equals("")) {
    		messageText.setText("Please input a username and password and confirm!");
    		return;
    	}
    	else if (input.exists()) {
    		messageText.setText("That username already exists!");
    		return;
    	}
    	else if (!password.equals(confirmPass)) {
    		messageText.setText("The passwords do not match!");
    		return;
    	}
    	else {
    		input.createNewFile();
            FileWriter output = new FileWriter(input);
            output.append(userName + "," + password);
            output.close();
    		messageText.setText("Your account has been registered!");
    	}
    	goBack(event);
    }
    
    public void goBack(MouseEvent event) {
    	logInButton.setVisible(true);
    	passConfirm.setVisible(false);
    	passwordInputTwo.setVisible(false);
    	registerAccount.setVisible(false);
    	backButton.setVisible(false);
    	newAccountButton.setVisible(true);
    }
}
