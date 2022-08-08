package main;

import java.util.ArrayList;

import controller.HomeScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Shoes;
import utilities.Csv;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

    /*
     * main method of the program will run and start the program
     * Parameters:
     * String[] args: The arguments given to the program while compiling and
     * running.
     * Returns:
     * No return
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * start is an overwritten method that will allow the program to open and
     * display the homeScreen
     * and will then allow the program to be run.
     * Parameters:
     * Stage primaryStage: the stage to be set and used when the program first runs
     * Returns:
     * No returns but will update the primaryStage with the home screen.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/homeScreen.fxml"));
            Parent root = loader.load();
            ArrayList<Shoes> uncheckedShoes = Csv.getShoesToCheckInFromCsv();
            HomeScreenController controller = loader.getController();
            controller.setToCheckIn(uncheckedShoes);
            Scene scene = new Scene(root, 586, 400);
            scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}