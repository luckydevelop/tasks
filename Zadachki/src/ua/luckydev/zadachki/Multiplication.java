package ua.luckydev.zadachki;

/**
 * Created by Lucky on 29.11.2015.
 */

//Реализовать умножения не используя знак умножить

public class Multiplication
{
    public static void main(String[] args)
    {
        System.out.println(mult(2, 5));
    }

    public static int mult(int a, int b)
    {
        int a2 = Math.abs(a);
        int b2 = Math.abs(b);

        int min=0;
        int max=0;

        if (a2<b2)
        {
            min=a2;
            max=b2;
        }
        else
        {
            min=b2;
            max=a2;
        }

        int sum = 0;

        for(int i=min; i>=1; i--)  sum = sum+max;

        if ((a<0 && b<0)||(a>0 && b>0)) return sum;
        else return -sum;
    }
}
