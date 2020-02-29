package lv.accenture.bootcamp.enums;

public enum CupSize {

    SMALL(150), MEDIUM(250), LARGE(500);

    private int volume;

    CupSize(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
