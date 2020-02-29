package lv.accenture.bootcamp.io.conveyor;

import lv.accenture.bootcamp.io.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pipeline {

    @Autowired
    @Qualifier("BinaryConverter")
    private Converter binaryConverter;

    @Autowired
    @Qualifier("XMLConverter")
    private Converter xmlConverter;

    @Autowired
    @Qualifier("JSONConverter")
    private Converter jsonConverter;

    @Autowired
    @Qualifier("DBConverter")
    private Converter dbConverter;

    public void performConversions() throws Exception {
        Course course = binaryConverter.readFromFile("students.data");

        xmlConverter.writeToFile(course, "./documents/course-data.xml");
        Course xmlCourse = xmlConverter.readFromFile("./documents/course-data.xml");
        assert course.equals(xmlCourse) : "XML conversion step failed!";

        jsonConverter.writeToFile(xmlCourse, "./documents/course-json.json");
        Course jsonCourse = jsonConverter.readFromFile("./documents/course-json.json");
        assert course.equals(jsonCourse) : "JSON conversion step failed!";

        dbConverter.writeToFile(jsonCourse, "./documents/course-id.txt");
        Course dbCourse = dbConverter.readFromFile("./documents/course-id.txt");
        assert course.equals(dbCourse) : "DB conversion step failed!";

        System.out.println("Conversions complete!");
    }

}
