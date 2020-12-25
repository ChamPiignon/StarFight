package controllers;

import domaine.properties.Language;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LaunchPage {
    private ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");

    @FXML
    TableColumn playerColumn, numberColumn, statColumn, bestColumn;

    @FXML
    Button btn_play, btn_exit;

    @FXML
    ComboBox<Language> Cb_language;

    @FXML
    public void initialize() {
        initializeText();
        Cb_language.getItems().addAll(
                new Language("Default", Locale.getDefault()),
                new Language("English", Locale.ENGLISH),
                new Language("French", Locale.FRENCH)
        );
        Cb_language.getSelectionModel().selectFirst();
        Cb_language.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(Cb_language.getValue().toString());
                System.out.println(Cb_language.getValue().getLanguage());
                setBundle(ResourceBundle.getBundle("domaine/properties/langue", Cb_language.getValue().getLanguage()));
            }
        });
    }

    private void initializeText() {
        playerColumn.setText(bundle.getString("PlayerColumn"));
        numberColumn.setText(bundle.getString("NumberColumn"));
        statColumn.setText(bundle.getString("StatColumn"));
        bestColumn.setText(bundle.getString("BestColumn"));
        btn_play.setText(bundle.getString("Btn_play"));
        btn_exit.setText(bundle.getString("Btn_exit"));
    }

    public void onClickPlay(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/chooseCharacter.fxml"));
        loader.setController(new ChooseCharacter(primaryStage, bundle));
        Parent root = loader.load();
        Scene gameScene = new Scene(root);
        primaryStage.setTitle(bundle.getString("GameTitleGame"));
        primaryStage.setScene(gameScene);
        primaryStage.getIcons().add(new Image("images/tux.png"));
        primaryStage.show();
    }

    public void onClickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
        initializeText();
    }
}
