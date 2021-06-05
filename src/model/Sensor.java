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
     * @param alias
     */
    public Sensor(String theName, String alias) {
        super(theName, alias);
    }

    @Override
    public void trigger() {
        Controller.getNotificatons().add(new Notificaton(this.myName, this.getMyType().toString()));
    }

    public Sensor(String name) {
        super(name);
    }
}
