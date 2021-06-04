package model;

public class BlankDevice extends Device{
    public BlankDevice(String name) {
        super(name);
    }

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
}
