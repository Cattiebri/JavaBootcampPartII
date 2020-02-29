package lv.accenture.bootcamp.ifaces;

import lv.accenture.bootcamp.exc.WorkException;

public interface Employee extends Animal {

    boolean work(int hours) throws WorkException;

    String getName();

}