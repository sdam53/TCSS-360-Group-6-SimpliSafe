package model;

/**
 * Blank device used in the DeviceScene GUI
 */
public class BlankDevice extends Device{
    public BlankDevice(String name) {
        super(name);
    }

    /**
     * constructs the BlankDevice object
     * @param theName name of the blank device
     * @param alias the device type
     */
    public BlankDevice(String theName, String alias) {
        super(theName, alias);
    }


    @Override
    public DEVICE_STATUS getMyStatus() {
        return DEVICE_STATUS.NULL;
    }

    @Override
    public String getMyName() {
        return super.getMyName();
    }

    @Override
    public String getMyBattery() {
        return "...";
    }

    @Override
    public String getMyID() {
        return "...";
    }

    @Override
    public Component getMyType() {
        return super.getMyType();
    }

    @Override
    public void trigger(String myName) {

    }
}
