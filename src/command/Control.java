package command;

public interface Control {
    boolean isRequestingUp();
    boolean isRequestingLeft();
    boolean isRequestingRight();
    boolean isRequestingPrimAtk();

    boolean isRequestingSndAtk();
}

