package model;

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

    public Sensor(String name) {
        super(name);
    }
}
