
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
       // ApplicationContext ac = new AnnotationConfigApplicationContext("BeanConfig.class");
        ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfig.class);
        HelloService helloService = (HelloService)ac.getBean("hello");
        System.out.println(helloService.sayHello());
    }
}
