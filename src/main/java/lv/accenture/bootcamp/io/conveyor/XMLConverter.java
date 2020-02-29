package lv.accenture.bootcamp.io.conveyor;

import lv.accenture.bootcamp.io.model.Course;
import lv.accenture.bootcamp.io.model.Lection;
import lv.accenture.bootcamp.io.model.Student;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("XMLConverter")
public class XMLConverter implements Converter {

    @Override
    public Course readFromFile(String path) throws Exception {
        SAXReader reader = new SAXReader();
        File courseFile = new File(path);
        Document document = reader.read(courseFile);
        Element courseElement = document.getRootElement();

        String dateFormat = courseElement.attributeValue("dateFormat");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        String title = courseElement.element("title").getText();
        String teacher = courseElement.element("teacher").getText();

        List<Node> studentsNodeList = courseElement.selectNodes("//Students/Student");

        List<Student> students = new ArrayList<>();
        for (Node studentElement : studentsNodeList) {
            String firstname = studentElement.selectSingleNode("firstname").getText();
            String lastname = studentElement.selectSingleNode("lastname").getText();
            String practiseCompany = studentElement.selectSingleNode("practiseCompany").getText();

            String ageString = studentElement.selectSingleNode("age").getText();
            byte age = Byte.parseByte(ageString);

             List<Node> lectionNodeList = studentElement.selectNodes("Lections/Lection");

            List<Lection> lections = new ArrayList<>();
            for (Node lectionElement : lectionNodeList) {

                String date = lectionElement.selectSingleNode("date").getText();
                Date parsedDate = simpleDateFormat.parse(date);

                String present = lectionElement.selectSingleNode("present").getText();
                boolean presenceFact = Boolean.parseBoolean(present);

                Byte markValue = null;
                Node markElement = lectionElement.selectSingleNode("mark");
                String markText = markElement.getText();
                if(markText != null && !markText.equals("")) {
                    markValue = Byte.parseByte(markText);
                }

                Lection lection = new Lection(parsedDate.getTime(), presenceFact, markValue);
                lections.add(lection);
            }
            Student student = new Student(firstname, lastname, age, practiseCompany);
            student.setDailyReports(lections);
            students.add(student);
        }

        return new Course(title, teacher, dateFormat, students);
    }

    @Override
    public void writeToFile(Course model, String path) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element courseElement = document.addElement("Course");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(model.getDateFormat());
        courseElement.addAttribute("dateFormat", model.getDateFormat());

        courseElement.addElement("title").setText(model.getCourseName());
        courseElement.addElement("teacher").setText(model.getTeacher());
        Element studentsElement = courseElement.addElement("Students");
        for (Student student : model.getStudents()) {
            Element studentElement = studentsElement.addElement("Student");
            studentElement.addElement("firstname").setText(student.getFirstName());
            studentElement.addElement("lastname").setText(student.getLastName());

            Element ageElement = studentElement.addElement("age");
            ageElement.addAttribute("unit", "years");
            ageElement.setText(String.valueOf(student.getAge()));

            studentElement.addElement("practiseCompany")
                    .setText(student.getPractiseCompany());

            Element lectionsElement = studentElement.addElement("Lections");
            for (Lection lection : student.getDailyReports()) {
                Element lectionElement = lectionsElement.addElement("Lection");
                String formattedDate = simpleDateFormat.format(lection.getDate());
                lectionElement.addElement("date").setText(formattedDate);

                String presenceFact = String.valueOf(lection.getPresence());
                lectionElement.addElement("present").setText(presenceFact);

                Element markElement = lectionElement.addElement("mark");
                if(lection.getMark() != null) {
                    markElement.setText(String.valueOf(lection.getMark()));
                }
            }
        }

        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fileOutputStream, format);
        writer.write(document);
        writer.close();
    }
}
