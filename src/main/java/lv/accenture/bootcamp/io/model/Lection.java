package lv.accenture.bootcamp.io.model;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Lection {

    private Long date;

    private Boolean presence;

    private Byte mark;

    public Lection(Long date, Boolean presence, Byte mark) {
        this.date = date;
        this.presence = presence;
        this.mark = mark;
    }

    public Long getDate() {
        return date;
    }

    public Boolean getPresence() {
        return presence;
    }

    public Byte getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lection lection = (Lection) o;
        return Objects.equals(date, lection.date) &&
                Objects.equals(presence, lection.presence) &&
                Objects.equals(mark, lection.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, presence, mark);
    }

    @Override
    public String toString() {
        return "\t\tLection{" +
                "date=" + date +
                ", presence=" + presence +
                ", mark=" + mark +
                "}\n";
    }

}
