package lv.accenture.bootcamp.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BinaryFileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("./documents/questionnaire.data");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        String name = "Jurijs";
        int age = 30;
        boolean hasCat = true;

        byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);

        dataOutputStream.writeBoolean(hasCat);
        dataOutputStream.writeInt(age);

        dataOutputStream.writeInt(nameBytes.length);
        dataOutputStream.write(nameBytes);

        dataOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        boolean hasCatFromFile = dataInputStream.readBoolean();
        int ageFromFile = dataInputStream.readInt();
        int nextStringLength = dataInputStream.readInt();
        byte[] nameBytesFromFile = new byte[nextStringLength];
        dataInputStream.read(nameBytesFromFile);
        String nameFromFile = new String(nameBytesFromFile, StandardCharsets.UTF_8);

        System.out.println("hasCatFromFile = " + hasCatFromFile);
        System.out.println("ageFromFile = " + ageFromFile);
        System.out.println("nameFromFile = " + nameFromFile);

        dataInputStream.close();

    }

}
