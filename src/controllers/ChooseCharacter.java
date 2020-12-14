package controllers;

import character.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class ChooseCharacter
{
    public ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");
    boolean player1IsReady = false;
    boolean player2IsReady = true;
    private Player player1;
    private Player player2;
    private Stage myStage;

    public ChooseCharacter(Stage myStage) {
        this.myStage = myStage;
    }

    public void setReadyPlayer2(ActionEvent actionEvent) throws IOException {
        player2IsReady = true;
        if(player1IsReady && player2IsReady)
            launchGame();
    }

    public void setReadyPlayer1(ActionEvent actionEvent) throws IOException {
        player1IsReady = true;
        if(player1IsReady && player2IsReady)
            launchGame();
    }


    private void launchGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/GamePage.fxml"));
        loader.setController(new GamePage(myStage));
        Parent root = loader.load();
        Scene gameScene= new Scene(root);
        myStage.setTitle(bundle.getString("GameTitleGame"));
        myStage.setScene(gameScene);
    }
}
