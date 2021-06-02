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
    private static ObservableList<Notificaton> notificatons = FXCollections.observableArrayList();

    public static ArrayList<Alarm> getAlarms() {
        return alarms;
    }

    public static ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public static ObservableList<Notificaton> getNotificatons() {
        return notificatons;
    }
}
