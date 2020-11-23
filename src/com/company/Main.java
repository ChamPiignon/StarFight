package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        // write your code here

        /*        // Properties avec ressource xml
        try( InputStream inputstream = PropertiesXml.class.getClass().getResourceAsStream("/labels_fr.xml"); ) {
            Properties props = new Properties();
            props.loadFromXML(inputstream);
            System.out.println("maCle1: " + props.getProperty("maCle1"));
        }


        // ResourceBundle avec ressource xml
        ResourceBundle bundle = ResourceBundle.getBundle("labels", new XMLResourceBundleControl());
        System.out.println("gameBtn_text: " + bundle.getString("gameBtn_text"));*/
        
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/menuView.fxml")); // url brute
        Parent root = loader.load();

        stage.setTitle("StarFight"); // text brute
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(250);
        stage.setMinHeight(150);
        stage.show();

    }
}