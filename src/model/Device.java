package model;

/**
 * abstract class representing devices for a security system
 */
public abstract class Device {

    /** enum for device status */
    public enum DEVICE_STATUS {ACTIVATED, DEACTIVATED, ALARMED}

    /** device status */
    protected DEVICE_STATUS myStatus;

    /** string for device name */
    protected String myName;

    /** double for device battery */
    protected int myBattery;

    /** string for device hash/ID */
    protected int myHash;

    /**
     * Constructs the Device object
     * @param theName name of device
     */
    public Device(String theName) {
        this.myStatus = DEVICE_STATUS.ACTIVATED;
        this.myName = theName;
        this.myBattery = (int)(Math.round(Math.random() * 100.0)); // myBattery will be between 0-100
        this.myHash = hashCode();
    }

    /**
     * returns device status
     * @return returns device status
     */
    public DEVICE_STATUS getMyStatus() {
        return myStatus;
    }

    /**
     * returns device name
     * @return returns device name
     */
    public String getMyName() {
        return myName;
    }

    /**
     * returns device battery level
     * @return returns device battery level
     */
    public int getMyBattery() {
        return myBattery;
    }

    /**
     * returns device hash/ID
     * @return returns device hash/ID
     */
    public int getMyHash() {
        return myHash;
    }

    /**
     * sets device status
     * @param theStatus device status
     */
    public void setMyStatus(DEVICE_STATUS theStatus) {
        this.myStatus = theStatus;
    }

    /**
     * sets device name
     * @param theName device name
     */
    public void setMyName(String theName) {
        this.myName = theName;
    }

    /**
     * sets device battery level
     * @param theBattery device battery level
     */
    public void setMyBattery(int theBattery) {
        this.myBattery = theBattery;
    }

    /**
     * sets device hash/ID
     * @param theHash device hash/ID
     */
    public void setMyHash(int theHash) {
        this.myHash = theHash;
    }

    @Override
    public String toString() {
        return "Device{" +
                "myStatus=" + myStatus +
                ", myName='" + myName + '\'' +
                ", myBattery=" + myBattery +
                ", myHash=" + myHash +
                '}';
    }
}
