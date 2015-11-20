package oleg.lucky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Lucky on 04.08.2015.
 */
public class Basket
{
    @Autowired
            @Qualifier("bottle2")
    Bottle bottle;
    String name = "Корзина";


    public void setBottle(Bottle bottle)
    {
        this.bottle = bottle;
    }


    @Override
    public String toString()
    {
        return name +" " + bottle;
    }
}
