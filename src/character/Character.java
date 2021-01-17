package character;

import javafx.beans.property.IntegerProperty;
import javafx.scene.shape.Rectangle;

/**
 * The type Character.
 */
public abstract class Character
{

    private IntegerProperty currentHP;
    private String name;
    private Rectangle hitbox;
    /**
     * The Is jumping.
     */
    public boolean isJumping = false;
    /**
     * The Is falling.
     */
    public boolean isFalling = false;
    /**
     * The Gravity.
     */
    public int gravity = 0;

    /**
     * Instantiates a new Character.
     *
     * @param hP   the h p
     * @param name the name
     */
    public Character(IntegerProperty hP, String name)
    {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        this.currentHP = hP;
        this.name = name;
    }

    /**
     * Instantiates a new Character.
     *
     * @param hP    the h p
     * @param maxHP the max hp
     * @param name  the name
     */
    public Character(IntegerProperty hP, int maxHP, String name)
    {
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        this.currentHP = hP;
        this.name = name;
    }


    /**
     * Gets hitbox.
     *
     * @return the hitbox
     */
    public Rectangle getHitbox() {
        return hitbox;
    }

    /**
     * Sets hitbox.
     *
     * @param hitbox the hitbox
     */
    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    /**
     * Gets current hp.
     *
     * @return the current hp
     */
    public IntegerProperty getCurrentHP()
    {
        return currentHP;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets current hp.
     *
     * @param hP the h p
     */
    public void setCurrentHP(IntegerProperty hP)
    {
        this.currentHP = hP;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
