package oleg.lucky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lucky on 04.08.2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Basket basket = (Basket)ac.getBean("basket");
        System.out.println(basket);
    }


}
