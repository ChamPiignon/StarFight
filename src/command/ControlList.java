package command;

import character.ListMove;
import controllers.KeyChoiceDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import java.util.ResourceBundle;

public class ControlList {
    private final String controlString;
    private final ListMove control;
    private final Button p1Btn;
    private final Button p2Btn;
    private final String p1ID;
    private final String p2ID;
    private final KeyboardCommand p1;
    private final KeyboardCommand p2;
    private final ResourceBundle bundle;

    /**
     *
     * @param controlString
     * @param control
     * @param p1
     * @param p2
     * @param bundle
     */
    public ControlList(String controlString, ListMove control, KeyboardCommand p1, KeyboardCommand p2, ResourceBundle bundle) {
        this.controlString = controlString;
        this.control = control;
        this.p1 = p1;
        this.p2 = p2;
        this.p1Btn = new Button(getP1String());
        this.p2Btn = new Button(getP2String());
        this.p1Btn.setId("p1");
        this.p2Btn.setId("p2");
        this.p1ID = this.p1Btn.getId();
        this.p2ID = this.p2Btn.getId();
        initBtn(p1Btn);
        initBtn(p2Btn);
        this.bundle = bundle;
    }

    /**
     *
     * @return
     */
    public Button getP1Btn() {
        return p1Btn;
    }

    /**
     *
     * @return
     */
    public Button getP2Btn() {
        return p2Btn;
    }

    /**
     *
     * @return
     */
    public String getControlString() {
        return controlString;
    }

    /**
     *
     * @return
     */
    public KeyCode getP1() {
        return getKeyCode(p1);
    }

    /**
     *
     * @return
     */
    public KeyCode getP2() {
        return getKeyCode(p2);
    }

    /**
     *
     * @return
     */
    public String getP1String() {
        return getStringKeyCode(p1);
    }

    /**
     *
     * @return
     */
    public String getP2String() {
        return getStringKeyCode(p2);
    }

    /**
     *
     * @param command
     * @return
     */
    private KeyCode getKeyCode(KeyboardCommand command) {
        switch (control) {
            case LEFT:
                return command.getLeft();
            case RIGHT:
                return command.getRight();
            case JUMP:
                return command.getJump();
            case PRIMATK:
                return command.getPrimAtk();
            case SNDATK:
                return command.getSndAtk();
            default:
                return null;
        }
    }

    /**
     *
     * @param command
     * @return
     */
    private String getStringKeyCode(KeyboardCommand command) {
        switch (control) {
            case LEFT:
                return command.getLeft().toString();
            case RIGHT:
                return command.getRight().toString();
            case JUMP:
                return command.getJump().toString();
            case PRIMATK:
                return command.getPrimAtk().toString();
            case SNDATK:
                return command.getSndAtk().toString();
            default:
                return null;
        }
    }

    /**
     *
     * @param btn
     */
    private void buttonAction(Button btn) {
        if (btn.getId().equals(p1ID)) {
            dialogEvent(new KeyChoiceDialog(bundle, KeyCode.valueOf(btn.getText())), p1, btn);

        } else if (btn.getId().equals(p2ID)) {
            dialogEvent(new KeyChoiceDialog(bundle, KeyCode.valueOf(btn.getText())), p2, btn);
        }
    }

    /**
     *
     * @param dialog
     * @param keyboardCommand
     * @param btn
     */
    private void dialogEvent(KeyChoiceDialog dialog, KeyboardCommand keyboardCommand, Button btn) {
        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                // show the dialog
                dialog.show();
            }
        };
        setKeyCode(keyboardCommand, dialog.getKey());
        btn.setText(dialog.getKey().toString());
    }

    /**
     *
     * @param command
     * @param newCommand
     */
    private void setKeyCode(KeyboardCommand command, KeyCode newCommand) {
        switch (control) {
            case LEFT:
                command.setLeft(newCommand);
                break;
            case RIGHT:
                command.setRight(newCommand);
                break;
            case JUMP:
                command.setJump(newCommand);
                break;
            case PRIMATK:
                command.setPrimAtk(newCommand);
                break;
            case SNDATK:
                command.setSndAtk(newCommand);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param btn
     */
    private void initBtn(Button btn) {
        btn.setOnAction(actionEvent -> buttonAction(btn));
    }
}
