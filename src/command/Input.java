package command;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The type Input.
 */
public class Input {

    private static boolean[] pressed;

    /**
     * Instantiates a new Input.
     */
    public Input() {
        pressed = new boolean[255];
    }

    /**
     * Key pressed.
     *
     * @param e the e
     */
    public static void keyPressed(KeyEvent e) {
        pressed[e.getCode().getCode()] = true;
    }

    /**
     * Key released.
     *
     * @param e the e
     */
    public static void keyReleased(KeyEvent e) {
        pressed[e.getCode().getCode()] = false;
    }

    /**
     * Is pressed boolean.
     *
     * @param keyCode the key code
     * @return boolean
     */
    public boolean isPressed(KeyCode keyCode) {
        return pressed[keyCode.getCode()];
    }
}