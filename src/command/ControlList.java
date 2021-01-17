package command;

import character.ListMove;
import controllers.KeyChoiceDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

import java.util.ResourceBundle;

/**
 * The type Control list.
 */
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
     * Instantiates a new Control list.
     *
     * @param controlString the control string
     * @param control       the control
     * @param p1            the p 1
     * @param p2            the p 2
     * @param bundle        the bundle
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
     * Gets p 1 btn.
     *
     * @return p 1 btn
     */
    public Button getP1Btn() {
        return p1Btn;
    }

    /**
     * Gets p 2 btn.
     *
     * @return p 2 btn
     */
    public Button getP2Btn() {
        return p2Btn;
    }

    /**
     * Gets control string.
     *
     * @return control string
     */
    public String getControlString() {
        return controlString;
    }

    /**
     * Gets p 1.
     *
     * @return p 1
     */
    public KeyCode getP1() {
        return getKeyCode(p1);
    }

    /**
     * Gets p 2.
     *
     * @return p 2
     */
    public KeyCode getP2() {
        return getKeyCode(p2);
    }

    /**
     * Gets p 1 string.
     *
     * @return p 1 string
     */
    public String getP1String() {
        return getStringKeyCode(p1);
    }

    /**
     * Gets p 2 string.
     *
     * @return p 2 string
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
