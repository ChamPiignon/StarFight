package controllers;

import character.ListMove;
import command.ControlList;
import command.KeyboardCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ResourceBundle;

public class DisplayControl extends Pane {
    private final KeyboardCommand p1Command;
    private final KeyboardCommand p2Command;
    private final ResourceBundle bundle;
    private static final int CELLHEIGHT = 31;
    private static final int CELLWIDTH = 100;
    private static final int COLUMNNUMBER = 3;

    @FXML
    TableView<ControlList> tableView;

    @FXML
    TableColumn<ControlList, String> controlColumn, p1Column, p2Column;

    @FXML
    public void initialize(){
        tableView.setPadding(new Insets(5));
        tableView.setEditable(true);

        Callback<TableColumn<ControlList, String>, TableCell<ControlList, String>> cellFactory
                = (TableColumn<ControlList, String> param) -> new EditingCell();

        controlColumn = new TableColumn<>(bundle.getString("ControlColumn"));
        p1Column = new TableColumn<>(bundle.getString("P1Column"));
        p2Column = new TableColumn<>(bundle.getString("P2Column"));

        controlColumn.setEditable(false);
        p1Column.setEditable(true);
        p2Column.setEditable(true);

        controlColumn.setCellValueFactory(new PropertyValueFactory<>("controlString"));
        p1Column.setCellValueFactory(new PropertyValueFactory<>("p1String"));
        p2Column.setCellValueFactory(new PropertyValueFactory<>("p2String"));

        p1Column.setCellFactory(cellFactory);
        p2Column.setCellFactory(cellFactory);

        p1Column.setOnEditCommit(
                (TableColumn.CellEditEvent<ControlList, String> t) -> {
                    t.getTableView().getItems()
                            .get(t.getTablePosition().getRow())
                            .setKey(t.getTablePosition().getColumn(),t.getNewValue());
                }
        );

        p2Column.setOnEditCommit(
                (TableColumn.CellEditEvent<ControlList, String> t) -> {
                    t.getTableView().getItems()
                            .get(t.getTablePosition().getRow())
                            .setKey(t.getTablePosition().getColumn(),t.getNewValue());
                }
        );

        ObservableList<ControlList> list = getControlList();
        tableView.setItems(list);
        tableView.setPrefSize(COLUMNNUMBER*CELLWIDTH, list.size()*CELLHEIGHT);
        tableView.getColumns().addAll(controlColumn, p1Column, p2Column);

    }

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

    private ObservableList<ControlList> getControlList() {
        ControlList left = new ControlList(bundle.getString("Left"), ListMove.LEFT, p1Command, p2Command);
        ControlList right = new ControlList(bundle.getString("Right"), ListMove.RIGHT, p1Command, p2Command);
        ControlList jump = new ControlList(bundle.getString("Jump"), ListMove.JUMP, p1Command, p2Command);
        ControlList primary_attack = new ControlList(bundle.getString("PrimAtk"), ListMove.PRIMATK, p1Command, p2Command);
        ControlList secondary_attack = new ControlList(bundle.getString("SndAtk"), ListMove.SNDATK, p1Command, p2Command);

        return FXCollections.observableArrayList(left, right, jump, primary_attack, secondary_attack);
    }
}
