package view;

import controller.Controller;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Component;
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

        HBox DeviceBox = new HBox();
        ChoiceBox DeviceChoice = new ChoiceBox();
        for (Component c: Component.values()) {
            DeviceChoice.getItems().add(c.toString());
        }
        TextField DeviceField = new TextField();
        Button DeviceButton = new Button("Press to create Device");

        DeviceButton.setOnAction(e -> {
            DeviceScene.addDevice(DeviceField.getText(), (String) DeviceChoice.getValue());
            DeviceField.setText("");
        });
        DeviceBox.getChildren().addAll(DeviceButton, DeviceChoice, DeviceField);
        notificationBox.setSpacing(30);
        notificationBox.setAlignment(Pos.CENTER);

        Separator separatorA = new Separator(Orientation.HORIZONTAL);
        Separator separatorB = new Separator(Orientation.HORIZONTAL);
        Separator separatorC = new Separator(Orientation.HORIZONTAL);

        VBox output = new VBox(title, separatorA, deviceBox, separatorB, notificationBox, separatorC, DeviceBox);
        output.setSpacing(30);

        this.pane = output;

    }
}
