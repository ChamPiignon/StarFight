package character;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;
import java.util.Map;
import java.util.TreeMap;

public class Fighter extends Character {
    private Skin skin;
    private StatMove statMove;

    public Fighter(String name) {
        super(new SimpleIntegerProperty(100),name);
        try {
            Map<StatMove,ImageView> skinsMap = new TreeMap<StatMove,ImageView>();
            skinsMap.put(StatMove.ATTACK1,new ImageView("/images/Fighters/"+getName()+"/Attack1.png"));
            skinsMap.put(StatMove.ATTACK2,new ImageView("/images/Fighters/"+getName()+"/Attack2.png"));
            skinsMap.put(StatMove.DEATH,new ImageView("/images/Fighters/"+getName()+"/Death.png"));
            skinsMap.put(StatMove.FALL,new ImageView("/images/Fighters/"+getName()+"/Fall.png"));
            skinsMap.put(StatMove.IDLE,new ImageView("/images/Fighters/"+getName()+"/Idle.png"));
            skinsMap.put(StatMove.JUMP,new ImageView("/images/Fighters/"+getName()+"/Jump.png"));
            skinsMap.put(StatMove.RUN,new ImageView("/images/Fighters/"+getName()+"/Run.png"));
            skinsMap.put(StatMove.TAKEHIT,new ImageView("/images/Fighters/"+getName()+"/Take hit.png"));
            System.out.println("Images de "+super.getName()+" chargés.");
            skin = new Skin(skinsMap);
            statMove = StatMove.IDLE;
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }

    public void setStatMove(StatMove statMove) {
        this.statMove = statMove;
    }

    public StatMove getStatMove() {
        return statMove;
    }

    public Skin getSkin() {
        return skin;
    }
}
