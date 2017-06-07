package it.polimi.ingsw.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayerboardMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/client/playerboard.fxml"));
        primaryStage.setTitle("Playerboard");
        primaryStage.setScene(new Scene(root, 770, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}