package lv.accenture.bootcamp.io.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {

    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        File personFile = new File("./documents/person-to-read.xml");
        Document document = reader.read(personFile);

        String personXml = document.asXML();
        System.out.println("personXml = " + personXml);

        Element personElement = document.getRootElement();

        String name = personElement.element("name").getText();
        String surname = personElement.element("surname").getText();

        Element ageElement = personElement.element("age");
        int age = Integer.parseInt(ageElement.getText());
        String ageUnit = ageElement.attributeValue("unit");
        System.out.println("ageUnit = " + ageUnit);

        Element domesticAnimalElement = personElement.element("domesticAnimal");

        String animalType = domesticAnimalElement.element("type").getText();
        String hamsterName = domesticAnimalElement.element("name").getText();

        List<String> toys = new ArrayList<>();

        Element toysElement = domesticAnimalElement.element("Toys");
        List<Element> toysElementList = toysElement.elements("Toy");
        if(toysElementList != null && toysElementList.size() > 0) {
            for(Element toyElement : toysElementList) {
                String toy = toyElement.getText();
                toys.add(toy);
            }
        }

        DomesticAnimal domesticAnimal = new DomesticAnimal(animalType, hamsterName, toys);
        Person person = new Person(name, surname, age, domesticAnimal);

        System.out.println("\n\nperson = " + person);
    }

}
