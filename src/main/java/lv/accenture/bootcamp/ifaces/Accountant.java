package lv.accenture.bootcamp.ifaces;

import java.util.Map;

public class Accountant {

    private Map<String, Double> salaries;

    public Double getSalary(Employee employee) {
        return salaries.get(employee.getName());
    }



}
