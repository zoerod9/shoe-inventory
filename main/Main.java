package main;

import java.util.ArrayList;

import controller.HomeScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Csv;
import model.Shoes;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Main is an extension of application and will launch and run the program initializing the screen and all the
 * information needed to run the program.
 * 
 * @authors Zoe Rodriguez (vcd011), Enrique Mata (rre165), William El Haber (csn639)
 * UTSA CS 3443 - shoe-inventory Team Project
 * Summer 2022
 */

public class Main extends Application {

    /*
     * main method of the program will run and start the program
     * @param args: The arguments given to the program while compiling and running.
     * @return No return
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * start is an overwritten method that will allow the program to open and
     * display the homeScreen and will then allow the program to be run.
     * @param primaryStage: the stage to be set and used when the program first runs
     * @return No returns but will update the primaryStage with the home screen.
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