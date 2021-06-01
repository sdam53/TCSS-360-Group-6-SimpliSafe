package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HistoryScene {
    public Pane getPane() {
        return this.pane;
    }

    Pane pane;

    public HistoryScene() {
        ListView historyList = new ListView();

        historyList.getItems().add("History item 1");
        historyList.getItems().add("History item 2");
        historyList.getItems().add("History item 3");
        historyList.getItems().add("      ...     ");
        historyList.getItems().add("History item X");

        this.pane = new Pane(new HBox(historyList));

    }
}
