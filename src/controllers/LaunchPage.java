package controllers;

import domaine.properties.Language;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Launch page.
 */
public class LaunchPage {
    private final Stage stage;
    private double stageWidth;
    private double stageHeight;
    private ResourceBundle bundle = ResourceBundle.getBundle("domaine/properties/langue");

    /**
     * The Player column.
     */
    @FXML
    TableColumn<String, String> playerColumn, /**
     * The Number column.
     */
    numberColumn, /**
     * The Stat column.
     */
    statColumn, /**
     * The Best column.
     */
    bestColumn;

    /**
     * The Btn play.
     */
    @FXML
    Button btn_play, /**
     * The Btn exit.
     */
    btn_exit;

    /**
     * The Cb language.
     */
    @FXML
    ComboBox<Language> Cb_language;

    /**
     * The Table view.
     */
    @FXML
    TableView<String> tableView;

    /**
     * The Title label.
     */
    @FXML
    Label titleLabel;

    /**
     * The Root.
     */
    @FXML
    StackPane root;

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {

        initializeText();
        initializeLanguages();
    }

    /**
     * Instantiates a new Launch page.
     *
     * @param myStage the my stage
     */
    public LaunchPage(Stage myStage) {
        this.stage = myStage;
        stage.widthProperty().addListener(e ->{
            this.stageWidth = stage.getWidth();
        });
        stage.heightProperty().addListener(e ->{
            this.stageHeight = stage.getHeight();
        });
    }

    /**
     * initialize the languages choice comboBox
     */
    private void initializeLanguages() {
        Cb_language.getItems().addAll(
                new Language("Default", Locale.getDefault()),
                new Language("English", Locale.ENGLISH),
                new Language("Français", Locale.FRENCH),
                new Language("日本語", Locale.JAPANESE)
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

    /**
     * initialize all text
     */
    private void initializeText() {
        playerColumn.setText(bundle.getString("PlayerColumn"));
        numberColumn.setText(bundle.getString("NumberColumn"));
        statColumn.setText(bundle.getString("StatColumn"));
        bestColumn.setText(bundle.getString("BestColumn"));
        btn_play.setText(bundle.getString("Btn_play"));
        btn_exit.setText(bundle.getString("Btn_exit"));
        titleLabel.setText(bundle.getString("GameTitle"));
    }

    /**
     * On click play.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    public void onClickPlay(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/chooseCharacter.fxml"));
        loader.setController(new ChooseCharacter(primaryStage, bundle));
        Parent root = loader.load();
        Scene gameScene = new Scene(root);
        primaryStage.setTitle(bundle.getString("GameTitleGame"));
        primaryStage.setScene(gameScene);
        primaryStage.getIcons().add(new Image("images/tux.png"));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(750);
        primaryStage.show();
    }

    /**
     * On click exit.
     *
     * @param actionEvent the action event
     */
    public void onClickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

    /**
     * Gets bundle.
     *
     * @return bundle
     */
    public ResourceBundle getBundle() {
        return bundle;
    }

    /**
     * Sets bundle.
     *
     * @param bundle the bundle
     */
    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
        initializeText();
    }
}
