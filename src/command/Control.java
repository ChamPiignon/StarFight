package command;

/**
 * The type Control.
 */
public abstract class Control {


    /**
     * The Input.
     */
    protected Input input = new Input();

    /**
     * Is requesting jump boolean.
     *
     * @return boolean
     */
    public abstract boolean isRequestingJump();

    /**
     * Is requesting left boolean.
     *
     * @return boolean
     */
    public abstract boolean isRequestingLeft();

    /**
     * Is requesting right boolean.
     *
     * @return boolean
     */
    public abstract boolean isRequestingRight();

    /**
     * Is requesting prim atk boolean.
     *
     * @return boolean
     */
    public abstract boolean isRequestingPrimAtk();

    /**
     * Is requesting snd atk boolean.
     *
     * @return boolean
     */
    public abstract boolean isRequestingSndAtk();

    /**
     * Init input.
     */
    public void initInput(){
        this.input= new Input();
    }

}

