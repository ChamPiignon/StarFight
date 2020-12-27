package command;

import javafx.scene.input.KeyCode;

import java.util.Locale;

public class ControlList {
    private String controlString;
    private final String control;
    private String p1String, p2String;
    private KeyboardCommand p1;
    private KeyboardCommand p2;

    public ControlList(String controlString, String control, KeyboardCommand p1, KeyboardCommand p2) {
        this.controlString = controlString;
        this.control = control;
        this.p1 = p1;
        this.p2 = p2;
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
            case "left":
                return command.getLeft();
            case "right":
                return command.getRight();
            case "jump":
                return command.getJump();
            case "primAtk":
                return command.getPrimAtk();
            case "sndAtk":
                return command.getSndAtk();
            default:
                return null;
        }
    }

    private String getStringKeyCode(KeyboardCommand command) {
        switch (control) {
            case "left":
                return command.getLeft().toString();
            case "right":
                return command.getRight().toString();
            case "jump":
                return command.getJump().toString();
            case "primAtk":
                return command.getPrimAtk().toString();
            case "sndAtk":
                return command.getSndAtk().toString();
            default:
                return null;
        }
    }

    public void setKey(int index, String command) {
        System.out.println(index);
        switch (index){
            case 1:
                setKeyCode(p1, command);
                break;
            case 2:
                setKeyCode(p2, command);
                break;
            default:
                break;
        }
    }

    private void setKeyCode(KeyboardCommand command, String newCommand) {
        switch (control) {
            case "left":
                command.setLeft(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case "right":
                command.setRight(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case "jump":
                command.setJump(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case "primAtk":
                command.setPrimAtk(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            case "sndAtk":
                command.setSndAtk(KeyCode.getKeyCode((newCommand).toUpperCase()));
                break;
            default:
                break;
        }
    }
}
