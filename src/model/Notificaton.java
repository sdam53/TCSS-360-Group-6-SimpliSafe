package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * This is a class for making the Notifications for the HistoryScene
 */
public class Notificaton {
    private String contents;
    private String time;
    private String kind;

    /**
     * Normal constructor except that it sets the time to the current time
     * @param contents
     * @param kind
     */
    public Notificaton(String contents, String kind) {
        this.contents = contents;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        this.time = dtf.format(now);
        this.kind = kind;
    }

    /**
     * basic toString method for display
     * @return
     */
    @Override
    public String toString() {
        return this.contents + " :: " + this.kind + " :: " + this.time;
    }
}
