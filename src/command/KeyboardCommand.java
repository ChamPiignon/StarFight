package command;


import javafx.scene.input.KeyCode;

import java.io.Serializable;

public class KeyboardCommand extends Control implements Serializable {
    private KeyCode jump;
    private KeyCode left;
    private KeyCode right;
    private KeyCode primAtk;
    private KeyCode sndAtk;

    /**
     *
     * @return
     */
    public KeyCode getJump() {
        return jump;
    }

    /**
     *
     * @param jump
     */
    public void setJump(KeyCode jump) {
        this.jump = jump;
    }

    /**
     *
     * @return
     */
    public KeyCode getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(KeyCode left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public KeyCode getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(KeyCode right) {
        this.right = right;
    }

    /**
     *
     * @return
     */
    public KeyCode getPrimAtk() {
        return primAtk;
    }

    /**
     *
     * @param primAtk
     */
    public void setPrimAtk(KeyCode primAtk) {
        this.primAtk = primAtk;
    }

    /**
     *
     * @return
     */
    public KeyCode getSndAtk() {
        return sndAtk;
    }

    /**
     *
     * @param sndAtk
     */
    public void setSndAtk(KeyCode sndAtk) {
        this.sndAtk = sndAtk;
    }

    /**
     *
     * @param player
     * @throws Exception
     */
    public KeyboardCommand(int player) throws Exception {

        if (player == 1) {
            setPlayer1();
        } else if (player == 2) {
            setPlayer2();
        } else throw new Exception("error player number");
    }

    /**
     * default command for player 1
     */
    public void setPlayer1() {
        this.setJump(KeyCode.Z);
        this.setLeft(KeyCode.Q);
        this.setRight(KeyCode.D);
        this.setPrimAtk(KeyCode.V);
        this.setSndAtk(KeyCode.B);
    }

    /**
     * default command for player 2
     */
    public void setPlayer2() {
        this.setJump(KeyCode.UP);
        this.setLeft(KeyCode.LEFT);
        this.setRight(KeyCode.RIGHT);
        this.setPrimAtk(KeyCode.NUMPAD0);
        this.setSndAtk(KeyCode.NUMPAD1);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isRequestingJump() {
        return input.isPressed(jump);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(left);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isRequestingRight() {
        return input.isPressed(right);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isRequestingPrimAtk() {
        return input.isPressed(primAtk);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isRequestingSndAtk() {
        return input.isPressed(sndAtk);
    }

}