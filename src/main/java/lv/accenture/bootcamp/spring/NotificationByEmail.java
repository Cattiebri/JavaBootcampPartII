package lv.accenture.bootcamp.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component ("email")
public class NotificationByEmail implements NotificationChannel {

    @Value("${notification.email.from}") //placeholder
    private String emailFrom;

    @Override
    public void notifyUser(User user) {
        System.out.println(user.getFullName() + " is notified on e-mail " + user.getEmail() + " sent from " + emailFrom);
    }
}
