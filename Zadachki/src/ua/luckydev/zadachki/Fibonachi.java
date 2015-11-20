package ua.luckydev.zadachki;

/**
 * Created by Lucky on 26.08.2015.
 */
public class Fibonachi
{
    public static void main(String[] args)
    {
        System.out.println("Zikl" +" "+zikl(10));
        System.out.println("Recursia" +" "+recur(10));
    }

    public static int recur(int n)
    {
        if(n==0) return 0;
        if(n==1) return 1;

        int res = recur(n-1)+recur(n-2);

        return res;
    }

    public static int zikl(int n)
    {
        int res=0;
        int f=0;
        int f1=1;

        for(int i=2; i<=n; i++)
        {
            res=f+f1;
            f=f1;
            f1=res;
        }

        return res;
    }

}
