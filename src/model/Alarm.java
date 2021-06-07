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
     * @param alias
     */
    public Alarm(String theName, String alias) {
        super(theName, alias);
    }

    /**
     * Method for triggering the alarm and simulating that behavior
     * @param triggeringDevice
     */
    @Override
    public void trigger(String triggeringDevice) {
        Controller.getNotificatons().add(new Notificaton(this.myName + " TRIGGERED FROM: " + triggeringDevice, this.getMyType().toString()));
        this.setStatus(DEVICE_STATUS.ALARMED);
    }

    public Alarm(String name) {
        super(name);
    }
}
