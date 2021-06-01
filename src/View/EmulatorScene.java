package View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class EmulatorScene {
    public Pane getPane() {
        return this.pane;
    }

    Pane pane;

    public EmulatorScene() {

        HBox interfaceBox = new HBox();
        TextField entryField = new TextField();
        Button entryButton = new Button("Press to send command");
        interfaceBox.getChildren().addAll(entryButton, entryField);

        interfaceBox.setSpacing(30);


        this.pane = new Pane(interfaceBox);

    }
}
