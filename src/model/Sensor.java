package model;

import controller.Controller;

/**
 * Sensor Object that extends Device which is used to
 * help with sorting and potentially with future logic
 */
public class Sensor extends Device{
    /**
     * Constructs the Device object
     *
     * @param theName name of device
     * @param alias the type of device
     */
    public Sensor(String theName, String alias) {
        super(theName, alias);
    }

    /**
     * Triggers the Sensor and simulates the relevant behavior
     * @param myName the name of the sensor
     */
    @Override
    public void trigger(String myName) {
        Controller.getNotificatons().add(new Notificaton(this.myName, this.getMyType().toString()));
        this.setStatus(DEVICE_STATUS.ALARMED);
    }

    /**
     * constructs the Sensor object
     * @param name the name of the Sensor object
     */
    public Sensor(String name) {
        super(name);
    }
}
