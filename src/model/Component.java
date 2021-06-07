package model;

/**
 * Class of Component Enums that are very helpful in a number
 * of different circumstances especially when it comes to GUI
 * having an array of each Device and related properties is
 * very useful
 */
public enum Component {
    ENTRYSENSOR("ENTRYSENSOR", "sensor"),
    MOTIONSENSOR("MOTIONSENSOR", "sensor"),
    GLASSBREAKSENSOR("GLASSBREAKSENSOR", "sensor"),
    SMOKEDETECTOR("SMOKEDETECTOR", "sensor"),
    COSENSOR("COSENSOR", "sensor"),
    TEMPERATURESENSOR("TEMPERATURESENSOR", "sensor"),
    WATERSENSOR("WATERSENSOR", "sensor"),
    SIREN("SIREN", "alarm"),
    NONCOMPONENT("...", "N/A");

    private String alias;
    private String kind;

    /**
     * basic Constructor
     * @param alias
     * @param kind
     */
    private Component(String alias, String kind) {

        this.alias = alias;
        this.kind = kind;
    }

    /**
     * basically an alias getter
     * @return
     */
    @Override
    public String toString() {
        return alias;
    }

    /**
     * kind getter
     * @return
     */
    public String getKind() {
        return kind;
    }

    /**
     * takes a String alias and returns the kind
     * @param alias
     * @return
     */
    public static String deriveKind(String alias) {
        for( Component c : Component.values() ) {
            if (c.alias.equals(alias)) {
                return c.getKind();
            }
        }
        return Component.NONCOMPONENT.getKind();
    }

    /**
     * Takes a String and returns the corresponding Compnent
     * @param alias
     * @return
     */
    public static Component getType(String alias) {
        for( Component c : Component.values() ) {
            if (c.alias.equals(alias)) {
                return c;
            }
        }
        return Component.NONCOMPONENT;
    }



}
