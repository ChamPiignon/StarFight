package character;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.Map;


public class Skin extends Pane
{
//    private int xPosition;
//    private int yPosition;
private Position position;

    public Map<StatMove, ImageView> images;
    private Rectangle hitbox;
    public SkinAnimation skinAnimation;
    private ImageView imageView;

    private final int width = 200;
    private final int height = 200;

    private final int xInit = 350;
    private final int yInit = 350;

    private String orientation="right";


    public Skin(Map<StatMove, ImageView> allSkins) {
        position = new Position(xInit, yInit);
        images = allSkins;
        imageView = new ImageView();
        imageView.setImage(images.get(StatMove.IDLE).getImage());
        skinAnimation = new SkinAnimation(imageView);
        getChildren().addAll(imageView);
    }

    public void refreshAnimation()
    {
        skinAnimation = new SkinAnimation(imageView);
    }


    public ImageView getImageView() { return imageView; }

    public void setImageView(ImageView imageView) {this.imageView = imageView;}
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}

    public Rectangle getHitbox() {return hitbox;}
    public void setHitbox(javafx.scene.shape.Rectangle hitbox) { this.hitbox = hitbox; }
    public ImageView getSpriteName(StatMove spriteName){return images.get(spriteName);}

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
