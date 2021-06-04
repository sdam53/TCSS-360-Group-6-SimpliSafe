package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
        ToggleGroup butonGroup = new ToggleGroup();
        ViewUtil.get().addAlwaysOneSelectedSupport(butonGroup);
        ToggleButton button1 = new ToggleButton("Home");
        button1.setToggleGroup(butonGroup);
        ToggleButton button2 = new ToggleButton("Away");
        button2.setToggleGroup(butonGroup);
        ToggleButton button3 = new ToggleButton("Off");
        button3.setToggleGroup(butonGroup);
        HBox buttons = new HBox(button1, button2, button3);

        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);
        this.pane.setCenter(buttons);

    }
}
