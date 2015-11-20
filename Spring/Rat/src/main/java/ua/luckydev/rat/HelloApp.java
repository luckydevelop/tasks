package ua.luckydev.rat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
       // ApplicationContext ac = new ClassPathXmlApplicationContext();
       // ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});
        Rat rat = (Rat) ac.getBean("rat");
       // Rat rat = (Rat)ac.getBean("rat");
        rat.sayHello();







//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        HelloService helloService = context.getBean(HelloService.class);
//        System.out.println(helloService.sayHello());
    }
}
