package controllers;

import character.Player;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import java.io.IOException;


/**
 * The type Health bar controller.
 */
public class HealthBarController extends VBox {
    private int maxHP;
    private Player player;
    private DoubleProperty currentHP = new SimpleDoubleProperty();
    /**
     * The Health bar.
     */
    @FXML
    public ProgressBar healthBar;

    @FXML
    private Label playerLabel;

    /**
     * Instantiates a new Health bar controller.
     *
     * @param player the player
     */
    public HealthBarController(Player player)
    {
        this.player = player;
        this.maxHP = player.getHisFighter().getCurrentHP().get();
        currentHP.bind(player.getHisFighter().getCurrentHP());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/healthBar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    /**
     * Initialize.
     */
    @FXML
    public void initialize()
    {
        playerLabel.setText(player.getName());
        healthBar.progressProperty().bind(currentHP.divide(maxHP));
    }


}
