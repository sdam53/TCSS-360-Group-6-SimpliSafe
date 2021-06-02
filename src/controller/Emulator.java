package controller;

import model.Alarm;
import model.Device;
import model.Sensor;

/**
 * This is the class that will handle the input from the GUI components
 * This means that all the Strings and Signals produced by the GUI will be
 * converted into usable information via the Controller
 */
public abstract class Emulator {

    public static Device genDevice(String kind, String name, String alias) {
        if(kind.equalsIgnoreCase("alarm")) {
            return new Alarm(name, alias);
        } else if (kind.equalsIgnoreCase("sensor")) {
            return new Sensor(name, alias);
        } else {
            return null;
        }
    }
}
