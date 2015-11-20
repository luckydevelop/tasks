package ua.luckydev.zadachki;

/**
 * Created by Lucky on 25.08.2015.
 */
public class Factorial
{
    public static void main(String[] args)
    {
        int resZikl = zikl(8);
        int resRecurs = zikl(8);
        System.out.println("Zikl" +" "+resZikl);
        System.out.println("Recursia" +" "+resRecurs);

    }

    public static int zikl(int n)
    {
        int fact=1;

        for(int i=2; i<=n; i++)
        {
            fact = fact*i;
        }

        return fact;
    }

    public static int recurs(int n)
    {
        int res=0;

        if(n>1) res = n*recurs(n-1); //int res - ?
        if(n==1) res=1;

        return res;

    }
}
