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
import model.Sensor;

import java.awt.event.ActionEvent;
import java.security.SecurityPermission;

import static view.DeviceScene.addDevice;

/**
 * This class is emulating what the hardware would do and has debug tools for
 * testing functionality
 */
public class EmulatorScene {

    /**
     * pane getter
     * @return
     */
    public Pane getPane() {
        return this.pane;
    }

    //Pane field
    Pane pane;

    /**
     * Constructor and init funciton
     */
    public EmulatorScene() {

        //Creating the Title which is in an HBox and consists of one label
        //to get it to center you have to set the Labels max width to a
        //arbitrarily large number which then causes it to behave when
        //telling it to center

        HBox titleBox = new HBox();
        Label title = new Label("Emulator");
        title.setFont(new Font(24));
        title.setMaxWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.CENTER);
        titleBox.getChildren().add(title);


        //Creates the section for adding notifications to the HistoryScene
        //consists of an HBox with a TextField and a button which will
        //send a test notification

        HBox notificationBox = new HBox();
        TextField notificationField = new TextField();
        Button notificationButton = new Button("Press to send notification");
        notificationBox.getChildren().addAll(notificationButton, notificationField);

        //adds a notification to the HistoryScene and then clears the text field
        notificationButton.setOnAction(e -> {
            Controller.getNotificatons().add(new Notificaton(notificationField.getText(), "TEST_NOTIFICATION"));
            notificationField.setText("");
        });
        notificationBox.setSpacing(30);
        notificationBox.setAlignment(Pos.CENTER);

        //This is the section for creating new Devices which is an HBox
        //with a Button, TextField, Choice Box full of all the Component Enums
        //reside for adding devices to the Device Scene

        HBox deviceBox = new HBox();
        TextField deviceField = new TextField();
        Button deviceButton = new Button("Press to send command");
        ChoiceBox deviceChoice = new ChoiceBox();
        //adds all the Component Strings to the ChoiceBox
        for (Component c: Component.values()) {
            deviceChoice.getItems().add(c.toString());
        }
        deviceBox.getChildren().addAll(deviceButton, deviceChoice, deviceField);
        deviceBox.setSpacing(30);
        deviceBox.setAlignment(Pos.CENTER);

        //adds a device to the DeviceScene and clears the deviceField as a function
        //to the deviceButton
        //also adds the device to the Controller class' arraylist that contains the devices
        deviceButton.setOnAction(e -> {
            DeviceScene.addDevice(deviceField.getText(), (String) deviceChoice.getValue());

            Controller.addDevice(deviceField.getText(), (String) deviceChoice.getValue());
            deviceField.setText("");



        });


        //Separators for aesthetics
        Separator separatorA = new Separator(Orientation.HORIZONTAL);
        Separator separatorB = new Separator(Orientation.HORIZONTAL);
        Separator separatorC = new Separator(Orientation.HORIZONTAL);

        //Output VBox for display
        VBox output = new VBox(title, separatorA, deviceBox, separatorB, notificationBox);
        output.setSpacing(30);
        this.pane = output;

    }
}
