package lv.accenture.bootcamp.io;

import java.io.*;

public class SimpleFileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("./documents/words.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for(int i = 0; i< 10; i++) {
            String s = "Line #" + i + "\n";
            bufferedWriter.write(s);
        }

        bufferedWriter.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = bufferedReader.readLine();
        while(s != null) {
            System.out.println(s);
            s = bufferedReader.readLine();
        }

        bufferedReader.close();

    }

}
