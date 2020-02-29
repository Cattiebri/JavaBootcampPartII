package lv.accenture.bootcamp.io.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class PersonWriter {

    public static void main(String[] args) throws Exception {
        List<String> toys = Arrays.asList("terrarium", "hamster");
        DomesticAnimal domesticAnimal = new DomesticAnimal("sneak", "Basilysk", toys);
        Person person = new Person("Vasya", "Pupkin", 50, domesticAnimal);

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("person");

        Element nameElement = root.addElement("name");
        nameElement.setText(person.getName());

        Element domesticAnimalElement = root.addElement("domesticAnimal");
        Element animalTypeElement = domesticAnimalElement.addElement("type");
        animalTypeElement.setText(person.getDomesticAnimal().getType());

        Element ageElement = root.addElement("age");
        int personAge = person.getAgeYears();
        ageElement.setText(String.valueOf(personAge));

        File file = new File("./documents/person-to-write.xml");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fileOutputStream, format);
        writer.write(document);
    }

}
