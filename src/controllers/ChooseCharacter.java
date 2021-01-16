package controllers;

import character.Fighter;
import command.KeyboardCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persist.CommandSerializer;

import java.util.ResourceBundle;

public class ChooseCharacter {
    public ResourceBundle bundle;
    boolean player1IsReady = false;
    boolean player2IsReady = false;
    private String player1Character, player2Character, player1Name, player2Name;
    private final Stage myStage;
    private DisplayControl displayControl;
    private KeyboardCommand p1Command, p2Command;
    private final String defaultNameP1  = "Florent";
    private final String defaultNameP2  = "Raphael";
    private Fighter fighter1 = new Fighter("ninja");
    private Fighter fighter2 = new Fighter("samourai");

    @FXML
    Text namePlayer1, namePlayer2;

    @FXML
    TextField nameInputPlayer1, nameInputPlayer2;

    @FXML
    Button btn_left, btn_right;

    @FXML
    Pane selectionP1, selectionP2;

    @FXML
    Pane controlTable;

    @FXML
    public void initialize() {

        displayControl = new DisplayControl(p1Command, p2Command,bundle);
        controlTable.getChildren().add(displayControl);
        namePlayer1.setText(bundle.getString("NamePlayer1"));
        namePlayer2.setText(bundle.getString("NamePlayer2"));
        btn_left.setText(bundle.getString("Btn_ready"));
        btn_right.setText(bundle.getString("Btn_ready"));

        fighter2.getSkin().skinAnimation.play();
        fighter1.getSkin().skinAnimation.play();
        selectionP2.getChildren().add(fighter2.getSkin());
        selectionP1.getChildren().add(fighter1.getSkin());


        nameInputPlayer1.setText(defaultNameP1);
        nameInputPlayer1.setPrefWidth(myStage.getWidth()/3);
        nameInputPlayer2.setText(defaultNameP2);
        nameInputPlayer2.setPrefWidth(myStage.getWidth()/3);
        player2Character = "Samourai";
        player1Character = "Ninja";
    }

    public ChooseCharacter(Stage myStage, ResourceBundle bundle) throws Exception {
        this.myStage = myStage;
        this.bundle = bundle;
        if (CommandSerializer.isSaved("player1")){
            p1Command = CommandSerializer.load("player1");
        }
        else p1Command = new KeyboardCommand(1);
        if (CommandSerializer.isSaved("player2")){
            p2Command = CommandSerializer.load("player2");
        }
        else p2Command = new KeyboardCommand(2);
    }

    public void setReadyPlayer2(ActionEvent actionEvent) throws Exception {
        btn_right.setText(bundle.getString("Btn_ready2"));
        player2Name = nameInputPlayer2.getText();
        player2IsReady = true;
        if (player1IsReady)
            launchGame();
    }

    public void setReadyPlayer1(ActionEvent actionEvent) throws Exception {
        btn_left.setText(bundle.getString("Btn_ready2"));
        player1Name = nameInputPlayer1.getText();
        player1IsReady = true;
        if(player2IsReady)
            launchGame();
    }

    public void selectSamouraiP1(ActionEvent actionEvent){
        refreshSelectionAnimation(fighter1,selectionP1,"Samourai");
    }

    public void selectNinjaP1(ActionEvent actionEvent){
        refreshSelectionAnimation(fighter1,selectionP1,"Ninja");
    }

    public void selectSamouraiP2(ActionEvent actionEvent){
        refreshSelectionAnimation(fighter2,selectionP2,"Samourai");
    }

    public void selectNinjaP2(ActionEvent actionEvent){
        refreshSelectionAnimation(fighter2,selectionP2,"Ninja");
    }



    private void refreshSelectionAnimation(Fighter fighter, Pane paneSelectionAnimation,String typePerso)
    {
        fighter = new Fighter(typePerso);
        fighter.getSkin().skinAnimation.play();
        paneSelectionAnimation.getChildren().set(0,fighter.getSkin());
    }

    private void launchGame() throws Exception {
        CommandSerializer.save("player1",p1Command);
        CommandSerializer.save("player2",p2Command);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/gamePage.fxml"));
        loader.setController(new GamePage(myStage,player1Name, fighter1, player2Name, fighter2,p1Command, p2Command));
        Parent root = loader.load();
        Scene gameScene= new Scene(root);

        myStage.setFullScreen(true);

        myStage.setTitle(bundle.getString("GameTitleGame"));
        myStage.getIcons().add(new Image("images/tux.png"));
        myStage.setScene(gameScene);
    }
}
