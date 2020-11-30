package character;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SkinAnimation extends Transition {

    private final ImageView image;
    private final Duration DURATION=Duration.millis(400);
    private final int COUNT;
    private final int COLUMNS;
    private final int ROWS=1;
    private final int WIDTH=200;
    private final int HEIGHT=200;
    private int offSetX=0;
    private int offSetY=0;

    public SkinAnimation(ImageView image) {
        this.image = image;
        this.COLUMNS = (int)(image.getImage().getWidth()/WIDTH);
        COUNT = COLUMNS*ROWS;

        setCycleDuration(DURATION);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);

        this.image.setViewport(new Rectangle2D(offSetX,offSetY,WIDTH,HEIGHT));
    }

    public void setOffSetX(int offSetX) {
        this.offSetX = offSetX;
    }

    public void setOffSetY(int offSetY) {
        this.offSetY = offSetY;
    }

    @Override
    protected void interpolate(double v)
    {
        int index = Math.min((int)Math.floor(COUNT*v),COUNT-1);
        int xIndex=(index%COLUMNS)*WIDTH+offSetX;
        int yIndex=(index/COLUMNS)*HEIGHT+offSetX;
        image.setViewport(new Rectangle2D(xIndex,yIndex,WIDTH,HEIGHT));
    }
}
