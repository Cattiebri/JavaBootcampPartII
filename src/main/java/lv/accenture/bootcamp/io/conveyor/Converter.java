package lv.accenture.bootcamp.io.conveyor;

import lv.accenture.bootcamp.io.model.Course;

public interface Converter {

    public Course readFromFile(String path) throws Exception;

    public void writeToFile(Course model, String path) throws Exception;

}
