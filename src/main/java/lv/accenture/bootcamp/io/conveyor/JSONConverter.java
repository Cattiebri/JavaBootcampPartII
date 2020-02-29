package lv.accenture.bootcamp.io.conveyor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lv.accenture.bootcamp.io.model.Course;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component("JSONConverter")
public class JSONConverter implements Converter {

    @Override
    public Course readFromFile(String path) throws Exception {
        Gson gson = new Gson();
        byte[] jsonBytes = Files.readAllBytes(Paths.get(path));
        String courseJSON = new String(jsonBytes, StandardCharsets.UTF_8);
        return gson.fromJson(courseJSON, Course.class);
    }

    @Override
    public void writeToFile(Course model, String path) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String courseJSON = gson.toJson(model);
        byte[] courseJSONBytes = courseJSON.getBytes(StandardCharsets.UTF_8);
        Files.write(Paths.get(path), courseJSONBytes);
    }
}
