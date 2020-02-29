package lv.accenture.bootcamp.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component ("sms")
public class NotificationBySms implements NotificationChannel{

    @Value("${notification.sms.operator}") //placeholder
    private String operator;

    @Override
    public void notifyUser(User user) {
        System.out.println(user.getFullName() + " is notified by sms on number " + user.getNumber() + " provided by " + operator);
    }
}
