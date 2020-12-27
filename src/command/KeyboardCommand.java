package command;


import javafx.scene.input.KeyCode;

public class KeyboardCommand implements Control {
    private final Input input;
    private KeyCode jump;
    private KeyCode left;
    private KeyCode right;
    private KeyCode primAtk;
    private KeyCode sndAtk;

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

    public KeyboardCommand(int player) throws Exception {
        this.input = new Input();
        if (player == 1) {
            setPlayer1();
        } else if (player == 2) {
            setPlayer2();
        } else throw new Exception("error player number");
    }

    /*
    default command for player 1
     */
    public void setPlayer1() {
        this.setJump(KeyCode.Z);
        this.setLeft(KeyCode.Q);
        this.setRight(KeyCode.D);
        this.setPrimAtk(KeyCode.V);
        this.setSndAtk(KeyCode.B);
    }

    /*
    default command for player 2
    */
    public void setPlayer2() {
        this.setJump(KeyCode.UP);
        this.setLeft(KeyCode.LEFT);
        this.setRight(KeyCode.RIGHT);
        this.setPrimAtk(KeyCode.NUMPAD0);
        this.setSndAtk(KeyCode.NUMPAD1);
    }

    @Override
    public boolean isRequestingJump() {
        return input.isPressed(jump);
    }

    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(left);
    }

    @Override
    public boolean isRequestingRight() {
        return input.isPressed(right);
    }

    @Override
    public boolean isRequestingPrimAtk() {
        return input.isPressed(primAtk);
    }

    @Override
    public boolean isRequestingSndAtk() {
        return input.isPressed(sndAtk);
    }

}