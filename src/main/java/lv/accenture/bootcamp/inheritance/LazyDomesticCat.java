package lv.accenture.bootcamp.inheritance;

import java.util.Objects;

public class LazyDomesticCat extends DomesticCat {

    private int chipId;

    public LazyDomesticCat(String name, int chipId) {
        super("Lazy " + name);
        this.chipId = chipId;
    }

    public int getChipId() {
        return chipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LazyDomesticCat that = (LazyDomesticCat) o;
        return chipId == that.chipId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chipId);
    }

    @Override
    public String toString() {
        return "LazyDomesticCat{" +
                "chipId=" + chipId +
                ", name='" + name + '\'' +
                '}';
    }
}
