package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainScene {

    public Pane getPane() {
        return this.pane;
    }

    Pane pane;

    public MainScene() {

        ToggleButton button1 = ViewUtil.getRoundButton("ARM");

        ToggleButton button2 = ViewUtil.getRoundButton("DISARM");
        ToggleButton button3 = ViewUtil.getRoundButton("OTHER");
        HBox buttons = new HBox(button1, button2, button3);

        buttons.setPadding(new Insets(100));
        buttons.setSpacing(10);
        buttons.setAlignment(Pos.TOP_CENTER);
        this.pane = new Pane(buttons);

    }
}
