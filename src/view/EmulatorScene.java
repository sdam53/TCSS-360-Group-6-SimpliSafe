package view;

import controller.Controller;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Notificaton;

import java.awt.event.ActionEvent;
import java.security.SecurityPermission;

public class EmulatorScene {
    public Pane getPane() {
        return this.pane;
    }

    Pane pane;

    public EmulatorScene() {


        HBox titleBox = new HBox();
        Label title = new Label("Emulator");
        title.setFont(new Font(24));

        //Fuck this it took me way to freaking long
        title.setMaxWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.CENTER);
        titleBox.getChildren().add(title);

        HBox deviceBox = new HBox();
        TextField deviceField = new TextField();
        Button deviceButton = new Button("Press to send command");
        deviceBox.getChildren().addAll(deviceButton, deviceField);

        deviceBox.setSpacing(30);
        deviceBox.setAlignment(Pos.CENTER);

        HBox notificationBox = new HBox();
        TextField notificationField = new TextField();
        Button notificationButton = new Button("Press to send notification");
        notificationBox.getChildren().addAll(notificationButton, notificationField);

        notificationButton.setOnAction(e -> {
            Controller.getNotificatons().add(new Notificaton(notificationField.getText(), "26:00", "TEST_NOTIFICATION"));
            notificationField.setText("");
        });
        notificationBox.setSpacing(30);
        notificationBox.setAlignment(Pos.CENTER);

        Separator separatorA = new Separator(Orientation.HORIZONTAL);
        Separator separatorB = new Separator(Orientation.HORIZONTAL);

        VBox output = new VBox(title, separatorA, deviceBox, separatorB, notificationBox);
        output.setSpacing(30);

        this.pane = output;

    }
}
