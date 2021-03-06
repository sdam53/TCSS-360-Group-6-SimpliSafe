package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import model.Alarm;
import model.Component;
import model.Device;
import model.Sensor;

/**
 * Class representing the MainScene GUI
 */
public class MainScene implements EventHandler<ActionEvent> {

    private ToggleButton homeButton;
    private ToggleButton awayButton;
    private ToggleButton offButton;
    private Label alarmState;


    /**
     * returns pane
     * @return pane
     */
    public Pane getPane() {
        return this.pane;
    }

    BorderPane pane = new BorderPane();

    /**
     * constructs the MainScene GUI
     */
    public MainScene() {

        //A few custom ToggleButtons in an HBOX
        ToggleGroup buttonGroup = new ToggleGroup();
        ViewUtil.get().addAlwaysOneSelectedSupport(buttonGroup);
        homeButton = new ToggleButton("Home");
        homeButton.setToggleGroup(buttonGroup);
        awayButton = new ToggleButton("Away");
        awayButton.setToggleGroup(buttonGroup);
        offButton = new ToggleButton("Off");
        offButton.setToggleGroup(buttonGroup);
        HBox buttons = new HBox(homeButton, awayButton, offButton);

        // Text area to display the state of the arm


        alarmState = new Label("No State");
        alarmState.setFont(new Font(24));
        alarmState.setMaxWidth(Double.MAX_VALUE);
        alarmState.setAlignment(Pos.CENTER);
        this.pane.setTop(alarmState);


        buttons.setSpacing(10);
        buttons.setAlignment(Pos.CENTER);
        this.pane.setCenter(buttons);

        homeButton.setOnAction(this);
        awayButton.setOnAction(this);
        offButton.setOnAction(this);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == homeButton) {
            homeState();
        } else if (actionEvent.getSource() == awayButton) {
            awayState();
        } else if (actionEvent.getSource() == offButton) {
            offState();
        }
        DeviceScene.update();

    }

    /**
     * will activate all devices except Motion Sensors, they will instead be deactivated
     */
    private void homeState() {
        for (Sensor sensor: Controller.getSensors()) {
            if (sensor.getMyType() == Component.MOTIONSENSOR) {
                sensor.setStatus(Device.DEVICE_STATUS.DEACTIVATED);
            } else {
                sensor.setStatus(Device.DEVICE_STATUS.ACTIVATED);
            }
        }
        for (Alarm alarm: Controller.getAlarms()) {
            alarm.setStatus(Device.DEVICE_STATUS.ACTIVATED);
        }

        if(homeButton.isSelected()) {
            alarmState.setText("Home");

        }

    }

    /**
     * Will activate all devices
     */
    private void awayState() {
        for (Sensor sensor: Controller.getSensors()) {
            sensor.setStatus(Device.DEVICE_STATUS.ACTIVATED);
        }
        for (Alarm alarm: Controller.getAlarms()) {
            alarm.setStatus(Device.DEVICE_STATUS.ACTIVATED);
        }
        if(awayButton.isSelected()) {
            alarmState.setText("Away");
        }
    }

    /**
     * will deactivate all devices
     */
    private void offState() {
        for (Sensor sensor: Controller.getSensors()) {
            sensor.setStatus(Device.DEVICE_STATUS.DEACTIVATED);
        }
        for (Alarm alarm: Controller.getAlarms()) {
            alarm.setStatus(Device.DEVICE_STATUS.DEACTIVATED);
        }
        if(offButton.isSelected()) {
            alarmState.setText("Off");


        }
    }
}
