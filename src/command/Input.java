package command;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.Serializable;

public class Input {

    private static boolean[] pressed;

    public Input() {
        pressed = new boolean[255];
    }

    /**
     *
     * @param e
     */
    public static void keyPressed(KeyEvent e) {
        pressed[e.getCode().getCode()] = true;
    }

    /**
     *
     * @param e
     */
    public static void keyReleased(KeyEvent e) {
        pressed[e.getCode().getCode()] = false;
    }

    /**
     *
     * @param keyCode
     * @return
     */
    public boolean isPressed(KeyCode keyCode) {
        return pressed[keyCode.getCode()];
    }
}