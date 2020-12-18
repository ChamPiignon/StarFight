package command;

public interface Control {
    boolean isRequestingJump();

    boolean isRequestingLeft();

    boolean isRequestingRight();

    boolean isRequestingPrimAtk();

    boolean isRequestingSndAtk();

    boolean isRequestingDown();
}

