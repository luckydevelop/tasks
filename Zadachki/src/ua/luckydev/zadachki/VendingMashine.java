package ua.luckydev.zadachki;

import java.util.Comparator;
import java.util.TreeMap;

//Suppose you are a programmer for a vending machine manufacturer. Your company wants to streamline effort by giving
// out the fewest possible coins in change for each transaction. Suppose a customer puts in a dollar bill and purchases
// an item for 37 cents. What is the smallest number of coins you can use to make change? The answer is six coins: two
// quarters(25), one dime(10), and three pennies(1).
//        Write a function that prints set of coins in change using U.S. coins – 1, 5, 10, and 25 cent.


public class VendingMashine
{

    public static void main(String[] args)
    {
        getChange(37, 100);
    }

    private static void getChange(int cost, int money)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });
        map.put(25, 0);
        map.put(10, 0);
        map.put(05, 0);
        map.put(01, 0);
        int rest = money - cost;
        for( Integer coin : map.keySet())
        {
            int pcs = rest/coin;
            map.put(coin, pcs);
            rest = rest-(coin*pcs);
            if(pcs>0) System.out.println(coin + " cent, pcs "+pcs + " " + rest);
        }
    }
}
