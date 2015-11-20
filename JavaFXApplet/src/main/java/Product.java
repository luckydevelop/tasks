
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Lucky on 6/26/2015.
 */
public class Product
{
    private SimpleStringProperty productNameS;
    private SimpleStringProperty tmS;

    public Product(String productName, String tm)
    {
        productNameS = new SimpleStringProperty(productName);
        tmS = new SimpleStringProperty(tm);
    }


    public String getProductNameS()
    {
        return productNameS.get();
    }


    public void setProductNameS(String productNameS)
    {
        this.productNameS.set(productNameS);
    }

    public String getTmS()
    {
        return tmS.get();
    }


    public void setTmS(String tmS)
    {
        this.tmS.set(tmS);
    }

    @Override
    public String toString()
    {
        return String.format("Product name - \"%s\", TM - \"%s\"", getProductNameS(), getTmS());
    }





}
