package command;

import character.ListMove;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public class ControlList {
    private final String controlString;
    private final ListMove control;
    private Button p1Btn, p2Btn;
    private String p1ID, p2ID;
    private KeyboardCommand p1;
    private KeyboardCommand p2;

    public ControlList(String controlString, ListMove control, KeyboardCommand p1, KeyboardCommand p2) {
        this.controlString = controlString;
        this.control = control;
        this.p1 = p1;
        this.p2 = p2;
        this.p1Btn = new Button(getP1String());
        this.p2Btn = new Button(getP2String());
        this.p1ID = this.p1Btn.getId();
        this.p2ID = this.p2Btn.getId();
        initBtn(p1Btn);
        initBtn(p2Btn);
    }

    public Button getP1Btn() {
        return p1Btn;
    }

    public Button getP2Btn() {
        return p2Btn;
    }

    public String getControlString() {
        return controlString;
    }

    public KeyCode getP1() {
        return getKeyCode(p1);
    }

    public KeyCode getP2() {
        return getKeyCode(p2);
    }

    public String getP1String() {
        return getStringKeyCode(p1);
    }

    public String getP2String() {
        return getStringKeyCode(p2);
    }

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

    private void buttonAction(Button btn){
        System.out.println("btn");
        if (btn.getId().equals(p1ID)){
            setKeyCode(p1,"TODO");
        }
        else if (btn.getId().equals(p2ID)){
            setKeyCode(p2,"TODO");
        }
    }

    private void setKeyCode(KeyboardCommand command, String newCommand) {
        switch (control) {
            case LEFT:
                command.setLeft(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case RIGHT:
                command.setRight(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case JUMP:
                command.setJump(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case PRIMATK:
                command.setPrimAtk(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case SNDATK:
                command.setSndAtk(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            default:
                break;
        }
    }

    private void initBtn(Button btn){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonAction(btn);
            }
        });
    }
}
