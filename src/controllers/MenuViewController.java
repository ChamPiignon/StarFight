package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuViewController {
    @FXML
    Button gameBtn, settingBtn, exitBtn;

    public void startGame(ActionEvent actionEvent) {
        gameBtn.setText("game:OK");
    }

    public void openSetting(ActionEvent actionEvent) {
        settingBtn.setText("setting:OK");
    }

    public void exitMenu(ActionEvent actionEvent) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}
// bundle.getObject('gameBtn_text')