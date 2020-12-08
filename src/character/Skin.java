package character;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;

import java.util.Map;


public class Skin extends Pane
{

    private int xPosition;
    private int yPosition;
    public Map<String,ImageView> images;
    private Rectangle hitbox;
    public SkinAnimation skinAnimation;
    private ImageView imageView;

    private int width=200;
    private int height=200;


    public Skin(Map<String,ImageView> allSkins)
    {
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
    public void setXPosition(int xPosition) { this.xPosition = xPosition;}
    public void setYPosition(int yPosition) {this.yPosition = yPosition;}
    public int getXPosition() { return xPosition;}
    public int getYPosition() { return yPosition;}
    public Rectangle getHitbox() {return hitbox;}
    public void setHitbox(javafx.scene.shape.Rectangle hitbox) { this.hitbox = hitbox; }
    public ImageView getSpriteName(String spriteName){return images.get(spriteName);}
}
