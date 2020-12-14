package command;


import javafx.scene.input.KeyCode;

public class KeyboardCommandPlayer1 implements Control {
    private final Input input;
    private KeyCode jump = KeyCode.UP;
    private KeyCode left = KeyCode.LEFT;
    private KeyCode right = KeyCode.RIGHT;
    private KeyCode primAtk = KeyCode.NUMPAD0;
    private KeyCode sndAtk = KeyCode.NUMPAD1;

    public KeyCode getJump() {
        return jump;
    }

    public void setJump(KeyCode jump) {
        this.jump = jump;
    }

    public KeyCode getLeft() {
        return left;
    }

    public void setLeft(KeyCode left) {
        this.left = left;
    }

    public KeyCode getRight() {
        return right;
    }

    public void setRight(KeyCode right) {
        this.right = right;
    }

    public KeyCode getPrimAtk() {
        return primAtk;
    }

    public void setPrimAtk(KeyCode primAtk) {
        this.primAtk = primAtk;
    }

    public KeyCode getSndAtk() {
        return sndAtk;
    }

    public void setSndAtk(KeyCode sndAtk) {
        this.sndAtk = sndAtk;
    }

    public KeyboardCommandPlayer1(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingJump() {
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