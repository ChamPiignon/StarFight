package controllers;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class KeyChoiceDialog extends ChoiceDialog<KeyCode> {
    private KeyCode key;

    public KeyChoiceDialog(ResourceBundle bundle, KeyCode oldKey) {
        List<KeyCode> choices = new ArrayList<>();
        initializeChoices(choices);

        System.out.println(oldKey);
        this.key = oldKey;
        ChoiceDialog<KeyCode> dialog = new ChoiceDialog<>(key, choices);

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("images/tux.png"));
        dialog.setTitle(bundle.getString("ChoiceDialogTitle"));
        dialog.setHeaderText(bundle.getString("ChoiceDialogInfo"));
        dialog.setContentText(bundle.getString("ChoiceDialogKey"));

        Optional<KeyCode> result = dialog.showAndWait();

        result.ifPresent(keyCode -> {System.out.println("Your choice: " + keyCode); this.key = keyCode;});
    }

    public KeyCode getKey() {
        return key;
    }

    private void initializeChoices(List<KeyCode> choices){
        choices.add(KeyCode.A);
        choices.add(KeyCode.Z);
        choices.add(KeyCode.E);
        choices.add(KeyCode.R);
        choices.add(KeyCode.T);
        choices.add(KeyCode.Y);
        choices.add(KeyCode.U);
        choices.add(KeyCode.I);
        choices.add(KeyCode.O);
        choices.add(KeyCode.P);
        choices.add(KeyCode.Q);
        choices.add(KeyCode.S);
        choices.add(KeyCode.D);
        choices.add(KeyCode.F);
        choices.add(KeyCode.G);
        choices.add(KeyCode.H);
        choices.add(KeyCode.J);
        choices.add(KeyCode.K);
        choices.add(KeyCode.L);
        choices.add(KeyCode.M);
        choices.add(KeyCode.W);
        choices.add(KeyCode.X);
        choices.add(KeyCode.C);
        choices.add(KeyCode.V);
        choices.add(KeyCode.B);
        choices.add(KeyCode.N);
        choices.add(KeyCode.SPACE);
        choices.add(KeyCode.ALT);
        choices.add(KeyCode.ALT_GRAPH);
        choices.add(KeyCode.CONTROL);
        choices.add(KeyCode.SHIFT);
        choices.add(KeyCode.COMPOSE);
        choices.add(KeyCode.DELETE);
        choices.add(KeyCode.ESCAPE);
        choices.add(KeyCode.DIVIDE);
        choices.add(KeyCode.HOME);
        choices.add(KeyCode.PASTE);
        choices.add(KeyCode.QUOTE);
        choices.add(KeyCode.UNDERSCORE);
        choices.add(KeyCode.BACK_QUOTE);
        choices.add(KeyCode.BACK_SPACE);
        choices.add(KeyCode.ACCEPT);
        choices.add(KeyCode.ADD);
        choices.add(KeyCode.NUMPAD0);
        choices.add(KeyCode.NUMPAD1);
        choices.add(KeyCode.NUMPAD2);
        choices.add(KeyCode.NUMPAD3);
        choices.add(KeyCode.NUMPAD4);
        choices.add(KeyCode.NUMPAD5);
        choices.add(KeyCode.NUMPAD6);
        choices.add(KeyCode.NUMPAD7);
        choices.add(KeyCode.NUMPAD8);
        choices.add(KeyCode.NUMPAD9);
        choices.add(KeyCode.UP);
        choices.add(KeyCode.DOWN);
        choices.add(KeyCode.LEFT);
        choices.add(KeyCode.RIGHT);
    }
}
