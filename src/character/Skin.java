package character;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.Map;


/**
 * The type Skin.
 */
public class Skin extends Pane
{
private Position position;

    /**
     * The Images.
     */
    public Map<StatMove, ImageView> images;
    private Rectangle hitbox;
    /**
     * The Skin animation.
     */
    public SkinAnimation skinAnimation;
    private ImageView imageView;

    private final int width = 200;
    private final int height = 200;

    private final int xInit = 350;
    private final int yInit = 350;

    /**
     * Instantiates a new Skin.
     *
     * @param allSkins the all skins
     */
    public Skin(Map<StatMove, ImageView> allSkins) {
        position = new Position(xInit, yInit);
        images = allSkins;
        imageView = new ImageView();
        imageView.setImage(images.get(StatMove.IDLE).getImage());
        skinAnimation = new SkinAnimation(imageView);
        getChildren().addAll(imageView);
    }

    /**
     * Refresh animation.
     */
    public void refreshAnimation()
    {
        skinAnimation = new SkinAnimation(imageView);
    }


    /**
     * Gets image view.
     *
     * @return the image view
     */
    public ImageView getImageView() { return imageView; }

    /**
     * Sets image view.
     *
     * @param imageView the image view
     */
    public void setImageView(ImageView imageView) {this.imageView = imageView;}

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {return position;}

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Position position) {this.position = position;}

    /**
     * Gets hitbox.
     *
     * @return the hitbox
     */
    public Rectangle getHitbox() {return hitbox;}

    /**
     * Sets hitbox.
     *
     * @param hitbox the hitbox
     */
    public void setHitbox(javafx.scene.shape.Rectangle hitbox) { this.hitbox = hitbox; }

    /**
     * Get sprite name image view.
     *
     * @param spriteName the sprite name
     * @return the image view
     */
    public ImageView getSpriteName(StatMove spriteName){return images.get(spriteName);}
}
