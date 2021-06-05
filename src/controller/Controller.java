package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.ArrayList;

/**
 * This class will have all the methods that convert logic into data.
 * This will also have all the data stored to be able to display.
 */
public abstract class Controller {

    private static ArrayList<Alarm> alarms = new ArrayList<>();
    private static ArrayList<Sensor> sensors = new ArrayList<>();

    //this is an ObservableList for compatability reasons
    private static ObservableList<Notificaton> notificatons = FXCollections.observableArrayList();

    public static ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public static ArrayList<Sensor> getSensors() {
        return sensors;
    }

    /**
     * Notification getter
     * @return
     */
    public static ObservableList<Notificaton> getNotificatons() {
        return notificatons;
    }

    /**
     * adds an device to either the sensors or alarms arraylist
     * @param name name of the device
     * @param alias the alias of the device
     */
    public static void addDevice(String name, String alias) {
        switch (alias) {
            case "COSENSOR", "WATERSENSOR", "TEMPERATURESENSOR", "MOTIONSENSOR", "GLASSBREAKSENSOR", "ENTRYSENSOR":
                sensors.add(new Sensor(name, alias));
                break;
            default:
                alarms.add(new Alarm(name, alias));
        }
    }
}
