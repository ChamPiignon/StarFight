package controllers;

import command.KeyboardCommand;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class KeyChoiceDialog extends ChoiceDialog<KeyCode> {
    public KeyChoiceDialog(ResourceBundle bundle, KeyboardCommand keyboardCommand, KeyCode oldKey) {
        List<KeyCode> choices = new ArrayList<>();
        choices.add(KeyCode.A);
        choices.add(KeyCode.Z);
        choices.add(KeyCode.E);

        ChoiceDialog<KeyCode> dialog = new ChoiceDialog<>(oldKey, choices);

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("images/tux.png"));
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText("Choose your letter:");

        Optional<KeyCode> result = dialog.showAndWait();

        result.ifPresent(keyCode ->System.out.println("Your choice: "+keyCode));
    }
}
