package controllers;

import character.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class ChooseCharacter {
    public ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");
    boolean player1IsReady = false;
    boolean player2IsReady = false;
    private Player player1;
    private Player player2;
    private final Stage myStage;

    @FXML
    Text namePlayer1, namePlayer2;

    @FXML
    Button btn_left, btn_right;

    @FXML
    public void initialize() {
        namePlayer1.setText(bundle.getString("NamePlayer1"));
        namePlayer2.setText(bundle.getString("NamePlayer2"));
        btn_left.setText(bundle.getString("Btn_ready"));
        btn_right.setText(bundle.getString("Btn_ready"));
    }

    public ChooseCharacter(Stage myStage) {
        this.myStage = myStage;
    }

    public void setReadyPlayer2(ActionEvent actionEvent) throws IOException {
        player2IsReady = true;
        if (player1IsReady && player2IsReady)
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
        myStage.getIcons().add(new Image("images/tux.png"));
        myStage.setScene(gameScene);
    }
}
