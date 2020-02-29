package lv.accenture.bootcamp.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    @Value("${greeting.prefix}")
    private String prefix;

    @Value("${greeting.suffix}")
    private String suffix;

    public void greet(String whom) {
        System.out.println(prefix + " " + whom + suffix);
    }

}
