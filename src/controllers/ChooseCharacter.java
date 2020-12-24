package controllers;

import character.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class ChooseCharacter {
    public ResourceBundle bundle;
    boolean player1IsReady = false;
    boolean player2IsReady = false;
    private String player1Character, player2Character, player1Name, player2Name;
    private final Stage myStage;

    @FXML
    Text namePlayer1, namePlayer2;

    @FXML
    TextField nameInputPlayer1, nameInputPlayer2;

    @FXML
    Button btn_left, btn_right;

    @FXML
    ImageView selectionP1, selectionP2;

    @FXML
    public void initialize() {
        namePlayer1.setText(bundle.getString("NamePlayer1"));
        namePlayer2.setText(bundle.getString("NamePlayer2"));
        btn_left.setText(bundle.getString("Btn_ready"));
        btn_right.setText(bundle.getString("Btn_ready"));

        nameInputPlayer1.setText("Florent");
        nameInputPlayer2.setText("Raphael");
        player2Character = "Samourai";
        player1Character = "Ninja";
    }

    public ChooseCharacter(Stage myStage, ResourceBundle bundle) {
        this.myStage = myStage;
        this.bundle = bundle;
    }

    public void setReadyPlayer2(ActionEvent actionEvent) throws Exception {
        btn_right.setText(bundle.getString("Btn_ready2"));
        player2Name = nameInputPlayer2.getText();
        player2IsReady = true;
        if (player1IsReady && player2IsReady)
            launchGame();
    }

    public void setReadyPlayer1(ActionEvent actionEvent) throws Exception {
        btn_left.setText(bundle.getString("Btn_ready2"));
        player1Name = nameInputPlayer1.getText();
        player1IsReady = true;
        if(player1IsReady && player2IsReady)
            launchGame();
    }

    public void selectSamouraiP1(ActionEvent actionEvent){
        selectionP1.setImage(new Image("/images/Fighters/Samourai/choose.png"));
        player1Character = "Samourai";
    }

    public void selectNinjaP1(ActionEvent actionEvent){
        selectionP1.setImage(new Image("/images/Fighters/Ninja/choose.png"));
        player1Character = "Ninja";
    }

    public void selectSamouraiP2(ActionEvent actionEvent){
        selectionP2.setImage(new Image("/images/Fighters/Samourai/choose.png"));
        player2Character = "Samourai";
    }

    public void selectNinjaP2(ActionEvent actionEvent){
        selectionP2.setImage(new Image("/images/Fighters/Ninja/choose.png"));
        player2Character = "Ninja";
    }

    private void launchGame() throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/GamePage.fxml"));
        loader.setController(new GamePage(myStage,player1Name, player1Character, player2Name, player2Character, bundle));
        Parent root = loader.load();
        Scene gameScene= new Scene(root);
        myStage.setTitle(bundle.getString("GameTitleGame"));
        myStage.getIcons().add(new Image("images/tux.png"));
        myStage.setScene(gameScene);
    }
}
