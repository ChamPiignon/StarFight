package controllers;

/**
 * The type Checker limit.
 */
public class CheckerLimit
{
    private final double LEFT_LIMIT;
    private final double RIGHT_LIMIT;

    /**
     * Instantiates a new Checker limit.
     *
     * @param leftLimit  the left limit
     * @param rightLimit the right limit
     */
    public CheckerLimit(double leftLimit, double rightLimit) {
        this.LEFT_LIMIT = leftLimit;
        this.RIGHT_LIMIT = rightLimit;
    }

    /**
     * Is left limit boolean.
     *
     * @param currentPosition the current position
     * @return boolean
     */
    public boolean isLeftLimit(double currentPosition)
    {
        if(currentPosition <= LEFT_LIMIT)
            return true;
        return false;
    }

    /**
     * Is right limit boolean.
     *
     * @param currentPosition the current position
     * @return boolean
     */
    public boolean isRightLimit(double currentPosition)
    {
        if(currentPosition >= RIGHT_LIMIT)
            return true;
        return false;
    }
}
