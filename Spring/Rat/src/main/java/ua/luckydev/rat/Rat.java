package ua.luckydev.rat;

/**
 * Created by Lucky on 04.08.2015.
 */
public class Rat
{
    String name;
    String text;

    public Rat(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void sayHello ()
    {
        System.out.println(name +" "+text);;
    }

}
