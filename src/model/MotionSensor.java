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

    /**
     * returns device sensitivity
     * @return device sensitivity
     */
    public int getSensitivity() {
        return this.mySensitivity;
    }

    /**
     * sets device sensitivity
     * @param theSensitivity device sensitivity
     */
    public void setSensitivity(int theSensitivity) {
        this.mySensitivity = theSensitivity;
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
