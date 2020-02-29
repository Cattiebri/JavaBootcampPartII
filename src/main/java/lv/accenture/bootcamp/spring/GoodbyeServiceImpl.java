package lv.accenture.bootcamp.spring;

import org.springframework.stereotype.Component;

@Component
public class GoodbyeServiceImpl implements GoodbyeService {

    @Override
    public void sayGoodbye(String whom) {

        System.out.println("Goodbye " + whom + ".");
    }

}
