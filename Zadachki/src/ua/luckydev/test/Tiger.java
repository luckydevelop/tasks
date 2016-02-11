package ua.luckydev.test;

class Tiger extends Cat implements HasWeight, HasSize
{
    public int getValue()
    {
        return 115;
    }

    public static void main(String[] args)
    {

        System.out.println(new Tiger().getValue());
    }
}

interface HasWeight
{
    int getValue();
}
interface HasSize
{
    int getValue();
}