package ua.luckydev.zadachki;

/**
 * Created by Lucky on 22.09.2015.
 */

public class Pascal
{
    public static void main(String[] args)
    {
        paskal(30);
    }

    private static void paskal(int lines)
    {
        int[][] array = new int[lines][];
        array[0] = new int [3];
        array[0][1]=1;

        for(int i=1; i<lines; i++)
        {
            array[i] = new int [i+2];
            for(int j=1; j<array[i].length-1; j++)  array[i][j]= array[i-1][j-1]+ array[i-1][j];
        }

        for (int i = 0; i <lines; i++)
        {
            System.out.printf("%"+(array.length-i+1)+"s", " " );
            for (int j = 0; j < array[i].length; j++) System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }
}

