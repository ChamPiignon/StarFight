package command;


import javafx.scene.input.KeyCode;

public class KeyboardCommand implements Control {
    private final Input input;

    public KeyboardCommand(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingUp() {
        return input.isPressed(KeyCode.UP);
    }

    @Override
    public boolean isRequestingDown() {
        return input.isPressed(KeyCode.DOWN);
    }

    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyCode.LEFT);
    }

    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyCode.RIGHT);
    }

    @Override
    public boolean isRequestingPrimAtk() {
        return input.isPressed(KeyCode.NUMPAD0);
    }
}