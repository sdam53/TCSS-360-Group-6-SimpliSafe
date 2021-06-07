package view;

import controller.Controller;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Simple Class that displays all the Notifications in controller
 * as a ListView
 */
public class HistoryScene {

    /**
     * pane getter
     * @return
     */
    public Pane getPane() {
        return this.pane;
    }

    //pane field
    BorderPane pane;

    //ListView field
    ListView historyList;

    /**
     * Constructor and init function
     */
    public HistoryScene() {
        //binds the ListView to the ArrayList and sets the ListView
        //As the center of the pane
        historyList = new ListView(Controller.getNotificatons());
        this.pane = new BorderPane();
        pane.setCenter(historyList);

    }
}
