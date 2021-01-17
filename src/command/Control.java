package command;

public abstract class Control {


    protected Input input = new Input();

    public abstract boolean isRequestingJump();

    public abstract boolean isRequestingLeft();

    public abstract boolean isRequestingRight();

    public abstract boolean isRequestingPrimAtk();

    public abstract boolean isRequestingSndAtk();

    public void initInput(){
        this.input= new Input();
    }

}

