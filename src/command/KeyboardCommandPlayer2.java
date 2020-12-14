package command;


import javafx.scene.input.KeyCode;

public class KeyboardCommandPlayer2 implements Control {
    private final Input input;

    public KeyboardCommandPlayer2(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingJump() {
        return input.isPressed(KeyCode.Z);
    }

    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyCode.Q);
    }

    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyCode.D);
    }

    @Override
    public boolean isRequestingPrimAtk() {
        return input.isPressed(KeyCode.V);
    }

    @Override
    public boolean isRequestingSndAtk() {
        return input.isPressed(KeyCode.B);
    }
}