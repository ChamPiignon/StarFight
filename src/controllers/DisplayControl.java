package controllers;

import character.ListMove;
import command.ControlList;
import command.KeyboardCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ResourceBundle;

public class DisplayControl extends Pane {
    private final KeyboardCommand p1Command;
    private final KeyboardCommand p2Command;
    private final ResourceBundle bundle;
    private static final int CELLHEIGHT = 40;
    private static final int CELLWIDTH = 100;
    private static final int COLUMNNUMBER = 3;

    @FXML
    TableView<ControlList> tableView;

    @FXML
    TableColumn<ControlList, String> controlColumn;
    @FXML
    TableColumn<ControlList, Button> p1Column, p2Column;

    /**
     *
     */
    @FXML
    public void initialize(){
        ObservableList<ControlList> list = getControlList();
        initTable(list);
    }

    /**
     *
     * @param list
     */
    private void initTable(ObservableList<ControlList> list){
        tableView.setPadding(new Insets(5));
        initCols();
        tableView.setItems(list);
        tableView.setPrefSize(COLUMNNUMBER*CELLWIDTH, list.size()*CELLHEIGHT);
        tableView.getColumns().addAll(controlColumn, p1Column, p2Column);
    }

    /**
     *
     */
    private void initCols(){
        controlColumn = new TableColumn<>(bundle.getString("ControlColumn"));
        p1Column = new TableColumn<>(bundle.getString("P1Column"));
        p2Column = new TableColumn<>(bundle.getString("P2Column"));

        controlColumn.setCellValueFactory(new PropertyValueFactory<>("controlString"));
        p1Column.setCellValueFactory(new PropertyValueFactory<>("p1Btn"));
        p2Column.setCellValueFactory(new PropertyValueFactory<>("p2Btn"));
    }

    /**
     *
     * @param p1Command
     * @param p2Command
     * @param bundle
     */
    public DisplayControl(KeyboardCommand p1Command, KeyboardCommand p2Command, ResourceBundle bundle) {
        this.p1Command = p1Command;
        this.p2Command = p2Command;
        this.bundle = bundle;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/displayControl.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     *
     * @return
     */
    private ObservableList<ControlList> getControlList() {
        ControlList left = new ControlList(bundle.getString("Left"), ListMove.LEFT, p1Command, p2Command, bundle);
        ControlList right = new ControlList(bundle.getString("Right"), ListMove.RIGHT, p1Command, p2Command, bundle);
        ControlList jump = new ControlList(bundle.getString("Jump"), ListMove.JUMP, p1Command, p2Command, bundle);
        ControlList primary_attack = new ControlList(bundle.getString("PrimAtk"), ListMove.PRIMATK, p1Command, p2Command, bundle);
        ControlList secondary_attack = new ControlList(bundle.getString("SndAtk"), ListMove.SNDATK, p1Command, p2Command, bundle);

        return FXCollections.observableArrayList(left, right, jump, primary_attack, secondary_attack);
    }
}
