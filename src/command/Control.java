package command;

import java.awt.event.KeyEvent;

public interface Control {
    boolean isRequestingUp();
    boolean isRequestingDown();
    boolean isRequestingLeft();
    boolean isRequestingRight();
    boolean isRequestingPrimAtk();
}

