package command;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input {

    private static boolean[] pressed;

    public Input() {
        pressed = new boolean[255];
    }

    public static void keyPressed(KeyEvent e) {
        pressed[e.getCode().getCode()] = true;
    }

    public static void keyReleased(KeyEvent e) {
        pressed[e.getCode().getCode()] = false;
    }

    public boolean isPressed(KeyCode keyCode) {
        return pressed[keyCode.getCode()];
    }

    public void keyTyped(KeyEvent e) {
    }
}