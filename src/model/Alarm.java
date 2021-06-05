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

    @Override
    public void trigger() {
        Controller.getNotificatons().add(new Notificaton(this.myName, this.getMyType().toString()));
    }

    public Alarm(String name) {
        super(name);
    }
}
