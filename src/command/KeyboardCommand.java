package command;


import javafx.scene.input.KeyCode;

import java.io.Serializable;

/**
 * The type Keyboard command.
 */
public class KeyboardCommand extends Control implements Serializable {
    private KeyCode jump;
    private KeyCode left;
    private KeyCode right;
    private KeyCode primAtk;
    private KeyCode sndAtk;

    /**
     * Gets jump.
     *
     * @return jump
     */
    public KeyCode getJump() {
        return jump;
    }

    /**
     * Sets jump.
     *
     * @param jump the jump
     */
    public void setJump(KeyCode jump) {
        this.jump = jump;
    }

    /**
     * Gets left.
     *
     * @return left
     */
    public KeyCode getLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(KeyCode left) {
        this.left = left;
    }

    /**
     * Gets right.
     *
     * @return right
     */
    public KeyCode getRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(KeyCode right) {
        this.right = right;
    }

    /**
     * Gets prim atk.
     *
     * @return prim atk
     */
    public KeyCode getPrimAtk() {
        return primAtk;
    }

    /**
     * Sets prim atk.
     *
     * @param primAtk the prim atk
     */
    public void setPrimAtk(KeyCode primAtk) {
        this.primAtk = primAtk;
    }

    /**
     * Gets snd atk.
     *
     * @return snd atk
     */
    public KeyCode getSndAtk() {
        return sndAtk;
    }

    /**
     * Sets snd atk.
     *
     * @param sndAtk the snd atk
     */
    public void setSndAtk(KeyCode sndAtk) {
        this.sndAtk = sndAtk;
    }

    /**
     * Instantiates a new Keyboard command.
     *
     * @param player the player
     * @throws Exception the exception
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