package model;

public class Notificaton {
    private String contents;
    private String time;
    private String kind;

    public Notificaton(String contents, String time, String kind) {
        this.contents = contents;
        this.time = time;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return this.contents + " :: " + this.kind + " :: " + this.time;
    }
}
