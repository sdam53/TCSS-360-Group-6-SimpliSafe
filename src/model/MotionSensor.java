package model;

public class MotionSensor extends Device {

    private int mySensitivity;


    /**
     * Constructs the Device object
     *
     * @param theName name of device
     */
    public MotionSensor(String theName) {
        super(theName);
        this.mySensitivity = (int)(Math.round(Math.random() * 100.0)); // mySensitivity will be between 0-100
    }

    @Override
    public String toString() {
        return "MotionSensor{" +
                "myStatus=" + myStatus +
                ", myName='" + myName + '\'' +
                ", myBattery=" + myBattery +
                ", myHash=" + myHash +
                ", mySensitivity=" + mySensitivity +
                '}';
    }
}
