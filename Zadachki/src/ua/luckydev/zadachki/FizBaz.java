package ua.luckydev.zadachki;

/**
 * Created by Lucky on 28.11.2015.
 */
public class FizBaz
{
    public static void main(String[] args)
    {
        printFizBaz();
    }

//    public static void printFizBaz ()
//    {
//        for(int i=1; i<=100; i++)
//        {
//            if (i%5==0 & i%3==0) System.out.println(i + "Fiz" + "Baz");
//            else if (i%5==0 & i%3!=0) System.out.println(i + "Baz");
//            else if (i%3==0 & i%5!=0) System.out.println(i + "Fiz");
//            else System.out.println(i);
//        }
//    }

    public static void printFizBaz ()
    {
        for(int i=1; i<=100; i++)
        {
            if(i%3==0 & i%5!=0) System.out.println(i + "Fiz");
            else if (i%5==0 & i%3!=0) System.out.println(i + "Baz");
            else if  (i%5==0 & i%3==0) System.out.println(i + "Fiz" + "Baz");
            else System.out.println(i);
        }
    }
}

//    public void printFizBaz ()
//    {
//        for(int i=1; i<100; i++)
//        {
//
//            if(i%3==0 & i%5!=0) System.Out.Print(i + 'Fiz');
//            elseif (i?5==0 & i%3!=0) System.Out.Print(i + 'Baz');
//            elseif  (i?5==0 & i%3==0) System.Out.Print(i + 'Fiz' + 'Baz');
//            else System.Out.Print(i);
//
//        }
//    }

