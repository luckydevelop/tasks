package ua.luckydev;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lucky on 04.08.2015.
 */

 @Configuration
public class HelloWordConfig
{
    @Bean(name="hello")
    public HelloWordImp helloWord()
    {
        return new HelloWordImp();
    }
}
