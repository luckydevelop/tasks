package ua.luckydev.zadachki;

import java.util.Arrays;

/**
 * Created by Lucky on 28.08.2015.
 */
public class Sort_Array
{


    public static void main(String[] args)
    {

        int[] test = {7, 100, 200, 2, 34, 9, 65};
        int[] test2 = {7, 100, 200, 2, 34, 9, 65};
        int[] testArrays = {7, 100, 200, 2, 34, 9, 65};

        Arrays.sort(testArrays);
       // printArray(testArrays);
        System.out.println(Arrays.toString(testArrays));
        System.out.println("111");

        

       // Arrays.sort(testArrays, );

        sortVozrostPuzVozr(test);
        printArray(test);

        sortVozrostPuzUbuv(test);
        printArray(test);

        sortVozrostsortPereborVozr(test2);
        printArray(test2);

        sortVozrostsortPereborUbuv(test2);
        printArray(test2);


    }


    public static void printArray(int[] t)
    {
        for(int i = 0; i < t.length; i++)
        {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    //??????????? ?????????? ??-???????????

    public static void sortVozrostPuzVozr(int[] t)
    {
        int temp = 0;

        for(int i=t.length-1; i>0; i--)
        {
            for(int j=0; j<i; j++)
            {
                if(t[j]>t[j+1])
                {
                    temp = t[j+1];
                    t[j+1]=t[j];
                    t[j]=temp;
                }
            }
        }
    }

    public static void sortVozrostPuzUbuv(int[] t)
    {
        int temp = 0;

        for(int i=t.length-1; i>0; i--)
        {
            for(int j=0; j<i; j++)
            {
                if(t[j]<t[j+1])
                {
                    temp = t[j+1];
                    t[j+1]=t[j];
                    t[j]=temp;
                }
            }
        }
    }

    int[] test2 = {7, 100, 200, 2, 34, 9, 65};
    public static void sortVozrostsortPereborVozr(int[] t)
    {
        for(int i=0; i<t.length; i++)
        {
            int min=t[i];
            int min_i=i;

            for(int j=i+1; j<t.length; j++)
            {
                if(min>t[j])
                {
                    min=t[j];
                    min_i=j;
                }
            }

            if(i!=min_i)
            {
                int temp=t[i];
                t[i]=min;
                t[min_i]=temp;
            }
        }
    }


    public static void sortVozrostsortPereborUbuv(int[] t)
    {
        for(int i=0; i<t.length; i++)
        {
            int max=t[i];
            int max_i=i;

            for(int j=i+1; j<t.length; j++)
            {
                if(max<t[j])
                {
                    max=t[j];
                    max_i=j;
                }
            }

            if(i!=max_i)
            {
                int temp=t[i];
                t[i]=max;
                t[max_i]=temp;
            }
        }
    }

}
