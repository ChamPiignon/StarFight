package command;

import javafx.scene.input.KeyCode;

public class ControlList {
    private String control;
    private KeyCode p1;
    private KeyCode p2;

    public ControlList(String control, KeyCode p1, KeyCode p2) {
        this.control = control;
        this.p1 = p1;
        this.p2 = p2;
    }

    public String getControl() {
        return control;
    }

    public KeyCode getP1() {
        return p1;
    }

    public void setP1(KeyCode p1) {
        this.p1 = p1;
    }

    public KeyCode getP2() {
        return p2;
    }

    public void setP2(KeyCode p2) {
        this.p2 = p2;
    }
}
