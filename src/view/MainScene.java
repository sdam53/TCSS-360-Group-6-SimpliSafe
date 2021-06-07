package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Alarm;
import model.Component;
import model.Device;
import model.Sensor;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * WIP just a few custom buttons
 */
public class MainScene implements EventHandler<ActionEvent> {

    private ToggleButton homeButton;
    private ToggleButton awayButton;
    private ToggleButton offButton;
    private TextArea alarmState;



    public Pane getPane() {
        return this.pane;
    }

    BorderPane pane = new BorderPane();

    public MainScene() {

        //A few custom ToggleButtons in an HBOX
        ToggleGroup butonGroup = new ToggleGroup();
        ViewUtil.get().addAlwaysOneSelectedSupport(butonGroup);
        homeButton = new ToggleButton("Home");
        homeButton.setToggleGroup(butonGroup);
        awayButton = new ToggleButton("Away");
        awayButton.setToggleGroup(butonGroup);
        offButton = new ToggleButton("Off");
        offButton.setToggleGroup(butonGroup);
        HBox buttons = new HBox(homeButton, awayButton, offButton);

        // Text area to display the state of the arm

        alarmState = new TextArea();
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
        //System.out.println(Controller.getSensors().size());
        //System.out.println(Controller.getAlarms().size());
        //for (Sensor sensor: Controller.getSensors()) {
        //    System.out.println(sensor);
        //}
        //System.out.println("new");
        //for (Alarm alarm: Controller.getAlarms()) {
        //    System.out.println(alarm);
        //}
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
