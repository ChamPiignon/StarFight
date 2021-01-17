package com.company;

import controllers.LaunchPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * The type Main.
 */
public class Main extends Application {

    private final ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage){

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/launchPage.fxml"));
            loader.setController(new LaunchPage(stage));
            Parent root = loader.load();
            stage.setTitle(bundle.getString("GameTitle"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.getIcons().add(new Image("images/tux.png"));
            stage.setMinWidth(300);
            stage.setMinHeight(200);
            stage.show();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}