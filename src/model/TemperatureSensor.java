package model;

public class TemperatureSensor extends Device {

    private double myTemperature;

    /**
     * Constructs the Device object
     *
     * @param theName name of device
     */
    public TemperatureSensor(String theName) {
        super(theName);
        this.myTemperature = Math.round(Math.random() * 10000.0) / 100.0; // myTemperature will be between 0-100 degrees Celsius
    }

    /**
     * returns device Temperature
     * @return device Temperature
     */
    public double getTemperature() {
        return this.myTemperature;
    }

    /**
     * sets device Temperature
     * @param theTemperature device Temperature
     */
    public void setTemperature(int theTemperature) {
        this.myTemperature = theTemperature;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "myStatus=" + myStatus +
                ", myName='" + myName + '\'' +
                ", myBattery=" + myBattery +
                ", myHash=" + myHash +
                ", myTemperature=" + myTemperature +
                '}';
    }
}
