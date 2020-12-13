package command;


import javafx.scene.input.KeyCode;

public class KeyboardCommandPlayer1 implements Control {
    private final Input input;

    public KeyboardCommandPlayer1(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingUp() {
        return input.isPressed(KeyCode.UP);
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

    @Override
    public boolean isRequestingSndAtk() {
        return input.isPressed(KeyCode.NUMPAD1);
    }
}