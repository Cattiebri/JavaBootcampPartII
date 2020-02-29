package lv.accenture.bootcamp;

import lv.accenture.bootcamp.io.conveyor.Pipeline;
import lv.accenture.bootcamp.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppLauncher implements CommandLineRunner {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GoodbyeService goodbyeService;

    @Autowired
    private Pipeline pipeline;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationBySms smsService;

    @Autowired
    private NotificationByEmail emailService;

    public static void main(String[] args) {
        SpringApplication.run(AppLauncher.class);
    }

    @Override
    public void run(String... args) throws Exception {
//        greetingService.greet("world");
//        goodbyeService.sayGoodbye("world");
//        pipeline.performConversions();

        User user = new User("Vasya Pupkin", "12345678", "v.pupkin@gmail.com");
        notificationService.spamPerson(user);

    }
}
