package model;

public enum Component {
    COSENSOR("COSENSOR", "sensor"),
    WATERSENSOR("WATERSENSOR", "sensor"),
    TEMPERATURESENSOR("TEMPERATURESENSOR", "sensor"),
    MOTIONSENSOR("MOTIONSENSOR", "sensor"),
    GLASSBREAKSENSOR("GLASSBREAKSENSOR", "sensor"),
    ENTRYSENSOR("ENTRYSENSOR", "sensor"),
    SMOKEALARM("SMOKEALARM", "alarm"),
    ENTRYALARM("ENTRYALARM", "alarm"),
    NONCOMPONENT("N/A", "N/A");

    private String alias;
    private String kind;

    private Component(String alias, String kind) {

        this.alias = alias;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return alias;
    }

    public String getKind() {
        return kind;
    }

    public static String deriveKind(String alias) {
        for( Component c : Component.values() ) {
            if (c.alias.equals(alias)) {
                return c.getKind();
            }
        }
        return Component.NONCOMPONENT.getKind();
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
