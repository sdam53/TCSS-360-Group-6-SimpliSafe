package model;

/**
 * abstract class representing devices for a security system
 */
public abstract class Device {

    /** enum for device status */
    public enum DEVICE_STATUS {
        ACTIVATED("ACTIVATED"),
        DEACTIVATED("DEACTIVATED"),
        ALARMED("ALARMED"),
        NULL("...");

        private String internal;

        DEVICE_STATUS(String internal) {
            this.internal = internal;
        }

        @Override
        public String toString() {
            return this.internal;
        }
    }

    /** device status */
    protected DEVICE_STATUS myStatus;

    /** string for device name */
    protected String myName;

    protected Component myType;

    /** double for device battery */
    protected int myBattery;

    /** string for device hash/ID */
    protected int myID;

    public Device(String name) {
        this.myStatus = DEVICE_STATUS.NULL;
        this.myName = name;
        this.myType = Component.NONCOMPONENT;
        this.myBattery = 0; // myBattery will be between 0-100
        this.myID = 0;
    }

    /**
     * Constructs the Device object
     * @param theName name of device
     */
    public Device(String theName, String alias) {
        this.myStatus = DEVICE_STATUS.ACTIVATED;
        this.myName = theName;
        this.myType = Component.getType(alias);
        this.myBattery = (int)(Math.round(Math.random() * 100.0)); // myBattery will be between 0-100
        this.myID = hashCode();
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
    public String getMyBattery() {
        return myBattery + "%";
    }

    /**
     * returns device hash/ID
     * @return returns device hash/ID
     */
    public String getMyID() {

        return Integer.toString(myID);
    }

    public Component getMyType() {
        return myType;
    }

    /**
     * sets device status
     * @param theStatus device status
     */
    public void setStatus(DEVICE_STATUS theStatus) {
        this.myStatus = theStatus;
    }

    /**
     * sets device name
     * @param theName device name
     */
    public void setName(String theName) {
        this.myName = theName;
    }

    /**
     * sets device battery level
     * @param theBattery device battery level
     */
    public void setBattery(int theBattery) {
        this.myBattery = theBattery;
    }

    /**
     * sets device hash/ID
     * @param theHash device hash/ID
     */
    public void setHash(int theHash) {
        this.myID = theHash;
    }

    public void setMyType(Component myType) {
        this.myType = myType;
    }

    @Override
    public String toString() {
        return "Device{" +
                "myStatus=" + myStatus +
                ", myName='" + myName + '\'' +
                ", myBattery=" + myBattery +
                ", myHash=" + myID +
                '}';
    }
}
