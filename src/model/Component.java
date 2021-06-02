package model;

public enum Component {
    COSENSOR("COSENSOR"),
    WATERSENSOR("WATERSENSOR"),
    TEMPERATURESENSOR("TEMPERATURESENSOR"),
    MOTIONSENSOR("MOTIONSENSOR"),
    GLASSBREAKSENSOR("GLASSBREAKSENSOR"),
    ENTRYSENSOR("ENTRYSENSOR"),
    SMOKEALARM("SMOKEALARM"),
    ENTRYALARM("ENTRYALARM"),
    NONCOMPONENT("N/A");

    private String alias;

    private Component(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return alias;
    }

    public static Component getType(String alias) {
        for( Component c : Component.values() ) {
            if (c.alias.equals(alias)) {
                return c;
            }
        }
        return Component.NONCOMPONENT;
    }



}
