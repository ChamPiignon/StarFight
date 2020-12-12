package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class LaunchPage {
    public ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");

    public void onClickPlay(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/GamePage.fxml"));

        loader.setController(new GamePage(primaryStage));

        Parent root = loader.load();

        Scene gameScene= new Scene(root);
        primaryStage.setTitle(bundle.getString("GameTitleGame"));

        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}
