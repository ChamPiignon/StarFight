package command;

public abstract class Control {


    protected Input input = new Input();

    /**
     *
     * @return
     */
    public abstract boolean isRequestingJump();

    /**
     *
     * @return
     */
    public abstract boolean isRequestingLeft();

    /**
     *
     * @return
     */
    public abstract boolean isRequestingRight();

    /**
     *
     * @return
     */
    public abstract boolean isRequestingPrimAtk();

    /**
     *
     * @return
     */
    public abstract boolean isRequestingSndAtk();

    /**
     *
     */
    public void initInput(){
        this.input= new Input();
    }

}

