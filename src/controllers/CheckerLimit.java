package controllers;

public class CheckerLimit
{
    private final double LEFT_LIMIT;
    private final double RIGHT_LIMIT;

    /**
     *
     * @param leftLimit
     * @param rightLimit
     */
    public CheckerLimit(double leftLimit, double rightLimit) {
        this.LEFT_LIMIT = leftLimit;
        this.RIGHT_LIMIT = rightLimit;
    }

    /**
     *
     * @param currentPosition
     * @return
     */
    public boolean isLeftLimit(double currentPosition)
    {
        if(currentPosition <= LEFT_LIMIT)
            return true;
        return false;
    }

    /**
     *
     * @param currentPosition
     * @return
     */
    public boolean isRightLimit(double currentPosition)
    {
        if(currentPosition >= RIGHT_LIMIT)
            return true;
        return false;
    }
}
