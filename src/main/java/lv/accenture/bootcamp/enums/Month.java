package lv.accenture.bootcamp.enums;

public enum  Month {

    JANUARY(31),
    FEBRUARY(28) {
        @Override
        public int getDays(int year) {
            int maxDays = super.getDays(year);
            return year % 4 == 0 ? maxDays + 1 : maxDays;
        }
    },
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private int maxDays;

    Month(int maxDays) {
        this.maxDays = maxDays;
    }

    public int getDays(int year) {
        return maxDays;
    }

}
