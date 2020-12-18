package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class LaunchPage {
    public ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");

    @FXML
    TableColumn playerColumn, numberColumn, statColumn, bestColumn;

    @FXML
    Button btn_play, btn_exit;

    @FXML
    public void initialize() {
        playerColumn.setText(bundle.getString("PlayerColumn"));
        numberColumn.setText(bundle.getString("NumberColumn"));
        statColumn.setText(bundle.getString("StatColumn"));
        bestColumn.setText(bundle.getString("BestColumn"));
        btn_play.setText(bundle.getString("Btn_play"));
        btn_exit.setText(bundle.getString("Btn_exit"));
    }

    public void onClickPlay(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/chooseCharacter.fxml"));
        loader.setController(new ChooseCharacter(primaryStage));
        Parent root = loader.load();
        Scene gameScene = new Scene(root);
        primaryStage.setTitle(bundle.getString("GameTitleGame"));
        primaryStage.setScene(gameScene);
        primaryStage.getIcons().add(new Image("images/tux.png"));
        primaryStage.show();
    }
}
