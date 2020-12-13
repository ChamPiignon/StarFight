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

    public Map<String, ImageView> images;
    private Rectangle hitbox;
    public SkinAnimation skinAnimation;
    private ImageView imageView;

    private final int width = 200;
    private final int height = 200;

    private final int xInit = 350;
    private final int yInit = 350;


    public Skin(Map<String, ImageView> allSkins) {
        position = new Position(xInit, yInit);
        images = allSkins;
        imageView = images.get("Idle");
        skinAnimation = new SkinAnimation(imageView);
        getChildren().addAll(imageView);
    }

    public void refreshAnimation()
    {
        skinAnimation = new SkinAnimation(imageView);
        getChildren().addAll(imageView);
    }


    public ImageView getImageView() { return imageView; }

    public void setImageView(ImageView imageView) {this.imageView = imageView;}
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}

    public Rectangle getHitbox() {return hitbox;}
    public void setHitbox(javafx.scene.shape.Rectangle hitbox) { this.hitbox = hitbox; }
    public ImageView getSpriteName(String spriteName){return images.get(spriteName);}
}
