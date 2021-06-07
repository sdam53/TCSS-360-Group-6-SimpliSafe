package model;

import controller.Controller;

/**
 * Alarm Object that extends Device which is used to
 * help with sorting and potentially with future logic
 */
public class Alarm extends Device{
    /**
     * Constructs the Device object
     *
     * @param theName name of device
     * @param alias device type
     */
    public Alarm(String theName, String alias) {
        super(theName, alias);
    }

    /**
     * Method for triggering the alarm and simulating that behavior
     * @param triggeringDevice the device that will be triggered
     */
    @Override
    public void trigger(String triggeringDevice) {
        Controller.getNotificatons().add(new Notificaton(this.myName + " TRIGGERED FROM: " + triggeringDevice, this.getMyType().toString()));
        this.setStatus(DEVICE_STATUS.ALARMED);
    }

    /**
     * Constructs the Alarm object
     * @param name the name of the alarm
     */
    public Alarm(String name) {
        super(name);
    }
}
