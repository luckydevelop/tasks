

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lucky on 06.08.2015.
 */
@Configuration
public class BeanConfig
{

    @Bean(name = "hello")
    public HelloService hello()
    {
        return new HelloService();
    }

}
