package character;

import javafx.beans.property.IntegerProperty;
import javafx.scene.shape.Rectangle;

public abstract class Character
{

    private IntegerProperty currentHP;
    private String name;
    private Rectangle hitbox;
    public boolean isJumping = false;
    public boolean isFalling = false;
    public int gravity = 0;

    public Character(IntegerProperty hP, String name)
    {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        this.currentHP = hP;
        this.name = name;
    }
    public Character(IntegerProperty hP, int maxHP, String name)
    {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        this.currentHP = hP;
        this.name = name;
    }




    public Rectangle getHitbox() {
        return hitbox;
    }
    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }
    public IntegerProperty getCurrentHP()
    {
        return currentHP;
    }
    public String getName()
    {
        return name;
    }
    public void setCurrentHP(IntegerProperty hP)
    {
        this.currentHP = hP;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}
