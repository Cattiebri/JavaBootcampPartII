package lv.accenture.bootcamp.ifaces;

import lv.accenture.bootcamp.exc.WorkException;

public class Developer extends EmployeeImpl {

    public final static int STANDARD_WORKING_DAY = 8;

    public Developer(String name) {
        super(name);
    }

    @Override
    public boolean work(int hours) throws WorkException {

        assert hours >= 0 && hours <= 24 : "Can't work negative amount of time";

        if (hours > STANDARD_WORKING_DAY) {
            throw new WorkException("Too much work");
        }
        return hours <= STANDARD_WORKING_DAY;
    }

    @Override
    public void sleep() {
        assert false : "?!";
    }
}
