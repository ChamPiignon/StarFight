package command;

public interface Control {

    Input input = new Input();

    boolean isRequestingJump();

    boolean isRequestingLeft();

    boolean isRequestingRight();

    boolean isRequestingPrimAtk();

    boolean isRequestingSndAtk();
}

