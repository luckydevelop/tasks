package ua.luckydev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Lucky on 04.08.2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HelloWordConfig.class);
        HelloWordImp hw = (HelloWordImp)ac.getBean("hello");
        hw.sayHello("Уря!!!!");
    }



}
