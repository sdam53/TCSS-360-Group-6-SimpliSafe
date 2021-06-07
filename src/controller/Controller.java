package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import view.DeviceScene;

import java.util.ArrayList;

/**
 * This class will have all the methods that convert logic into data.
 * This will also have all the data stored to be able to display.
 */
public abstract class Controller {

    /** ArrayList containing all alarms */
    private static ArrayList<Alarm> alarms = new ArrayList<>();

    /** ArrayList containing all sensors */
    private static ArrayList<Sensor> sensors = new ArrayList<>();

    //this is an ObservableList for compatibility reasons
    private static ObservableList<Notificaton> notifications = FXCollections.observableArrayList();

    /**
     * Getter for the alarm arraylist
     * @return alarm arraylist
     */
    public static ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    /**
     * getter for the sensor arraylist
     * @return sensor arraylist
     */
    public static ArrayList<Sensor> getSensors() {
        return sensors;
    }

    /**
     * Notification getter
     * @return notification
     */
    public static ObservableList<Notificaton> getNotificatons() {
        return notifications;
    }

    /**
     * adds an device to either the sensors or alarms arraylist
     * @param name name of the device
     * @param alias the alias of the device
     */
    public static void addDevice(String name, String alias) {
        switch (alias) {
            case "ENTRYSENSOR", "MOTIONSENSOR", "GLASSBREAKSENSOR", "SMOKEDETECTOR", "COSENSOR", "TEMPERATURESENSOR",
                    "WATERSENSOR" -> sensors.add(new Sensor(name, alias));
            default -> alarms.add(new Alarm(name, alias));
        }
    }

    /**
     * This takes a name of string and triggers the relevant device
     * by iterating through all the current devices
     * @param name the name of the triggered device
     */
    public static void triggerDevice(String name) {
        for (Device d:
                getSensors()) {
            if(d.getMyName().equalsIgnoreCase(name)) {
                d.trigger(d.getMyName());
                triggerAlarms(d);
                return;
            }
        }
        System.out.println("Found no matching devices");
    }

    /**
     * This triggers all the currently active Alarms in the system
     * @param initiatingDevice the device that set off the alarms
     */
    public static void triggerAlarms(Device initiatingDevice) {
        for (Device d:
             getAlarms()) {
            if (d.getMyStatus().equals(Device.DEVICE_STATUS.ACTIVATED)) {
                d.trigger(initiatingDevice.getMyName());
            }
        }

        DeviceScene.update();
    }

    /**
     * This method takes a String and makes sure
     * that it is not duplicated within the system
     * @param theName the name of the device
     * @return boolean of whether the name is already a device
     */
    public static boolean isDuplicateName(String theName) {
        for (Alarm alarm: alarms) {
            if (theName.equals(alarm.getMyName())) {
                return true;
            }
        }
        for (Sensor sensor: sensors) {
            if (theName.equals(sensor.getMyName())) {
                return true;
            }
        }
        return false;
    }

}
