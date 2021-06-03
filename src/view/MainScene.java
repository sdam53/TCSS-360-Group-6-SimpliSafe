package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * WIP just a few custom buttons
 */
public class MainScene {

    public Pane getPane() {
        return this.pane;
    }

    BorderPane pane = new BorderPane();

    public MainScene() {

        //A few custom ToggleButtons in an HBOX
        ToggleButton button1 = ViewUtil.getRoundButton("Home");
        ToggleButton button2 = ViewUtil.getRoundButton("Away");
        ToggleButton button3 = ViewUtil.getRoundButton("Off");
        HBox buttons = new HBox(button1, button2, button3);

        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);
        this.pane.setCenter(buttons);

    }
}
