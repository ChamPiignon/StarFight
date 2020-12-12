package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LaunchPage {
    public void onClickPlay(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/GamePage.fxml"));

        loader.setController(new GamePage());

        Parent root = loader.load();

        Scene gameScene= new Scene(root);
        primaryStage.setTitle("GamePage");

        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}
