package view;

import controller.Controller;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HistoryScene {
    public Pane getPane() {
        return this.pane;
    }

    BorderPane pane;
    ListView historyList;
    public HistoryScene() {
        historyList = new ListView(Controller.getNotificatons());
        this.pane = new BorderPane();
        pane.setCenter(historyList);

    }

    public void update() {

        historyList.refresh();
    }
}
