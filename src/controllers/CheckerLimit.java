package controllers;

public class CheckerLimit
{
    private final double LEFT_LIMIT;
    private final double RIGHT_LIMIT;

    public CheckerLimit(double leftLimit, double rightLimit) {
        this.LEFT_LIMIT = leftLimit;
        this.RIGHT_LIMIT = rightLimit;
    }

    public boolean isLeftLimit(double currentPosition)
    {
        if(currentPosition <= LEFT_LIMIT)
            return true;
        return false;
    }

    public boolean isRightLimit(double currentPosition)
    {
        if(currentPosition >= RIGHT_LIMIT)
            return true;
        return false;
    }
}
