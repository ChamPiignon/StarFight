package command;

import character.ListMove;
import javafx.scene.input.KeyCode;

public class ControlList {
    private String controlString;
    private final ListMove control;
    private String p1String, p2String;
    private KeyboardCommand p1;
    private KeyboardCommand p2;

    public ControlList(String controlString, ListMove control, KeyboardCommand p1, KeyboardCommand p2) {
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
}
