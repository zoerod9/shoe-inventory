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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // BorderPane root = new BorderPane();
            // Parent root = FXMLLoader.load(getClass().getResource("/view/homeScreen.fxml"));
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
