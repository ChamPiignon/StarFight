package controllers;

import command.ControlList;
import command.KeyboardCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ResourceBundle;

public class DisplayControl extends Pane {
    private KeyboardCommand p1Command, p2Command;
    private ResourceBundle bundle;
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
        controlColumn = new TableColumn<>(bundle.getString("ControlColumn"));
        p1Column = new TableColumn<>(bundle.getString("P1Column"));
        p2Column = new TableColumn<>(bundle.getString("P2Column"));

        controlColumn.setCellValueFactory(new PropertyValueFactory<>("control"));
        p1Column.setCellValueFactory(new PropertyValueFactory<>("p1"));
        p2Column.setCellValueFactory(new PropertyValueFactory<>("p2"));

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
        ControlList left = new ControlList(bundle.getString("Left"), p1Command.getLeft(), p2Command.getLeft());
        ControlList right = new ControlList(bundle.getString("Right"), p1Command.getRight(), p2Command.getRight());
        ControlList jump = new ControlList(bundle.getString("Jump"), p1Command.getJump(), p2Command.getJump());
        ControlList primary_attack = new ControlList(bundle.getString("PrimAtk"), p1Command.getPrimAtk(), p2Command.getPrimAtk());
        ControlList secondary_attack = new ControlList(bundle.getString("SndAtk"), p1Command.getSndAtk(), p2Command.getSndAtk());

        return FXCollections.observableArrayList(left, right, jump, primary_attack, secondary_attack);
    }
}
