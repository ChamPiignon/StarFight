package character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public class Fighter extends Character
{
    private Skin skin;

    public Fighter(int hP, String name) {

        super(hP, name);
        try {
            Map<String,ImageView> skinsMap = new TreeMap<String,ImageView>();
            skinsMap.put("Attack1",new ImageView("/images/Fighters/"+this.getName()+"/Attack1.png"));
            skinsMap.put("Attack2",new ImageView("/images/Fighters/"+this.getName()+"/Attack2.png"));
            skinsMap.put("Death",new ImageView("/images/Fighters/"+this.getName()+"/Death.png"));
            skinsMap.put("Fall",new ImageView("/images/Fighters/"+this.getName()+"/Fall.png"));
            skinsMap.put("Idle",new ImageView("/images/Fighters/"+this.getName()+"/Idle.png"));
            skinsMap.put("Jump",new ImageView("/images/Fighters/"+this.getName()+"/Jump.png"));
            skinsMap.put("Run",new ImageView("/images/Fighters/"+this.getName()+"/Run.png"));
            skinsMap.put("Take hit",new ImageView("/images/Fighters/"+this.getName()+"/Take hit.png"));
            System.out.println("Images de "+getName()+" chargés.");
            skin = new Skin(skinsMap);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }
    public Skin getSkin() {
        return skin;
    }
}
