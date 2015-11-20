package ua.luckydev.zadachki;


import java.util.HashMap;

//Throwing cats from am N-story building.
//        Suppose that you have an N story building and a bunch of cats. Suppose also that a cat dies if it is thrown off floor F or higher, and lives otherwise – you can check cat status after throwing by calling following function
//        boolean isAlive(Cat cat)
//        Write a program to determine the floor F by killing minimal number of cats. What will be this number?
//        P.S. You can’t reuse survived cat.


public class Cats

{
    public static int countCats = 0;
    public static int maxSaveFloor = 5;
    static int n=10; //floors of building
    static HashMap<Integer, Boolean> map = new HashMap<>();
    public static void main(String[] args)
    {
        System.out.printf("Floors = %d, save floor = %d  %n", n, maxSaveFloor);
        int floor = findFloor(1, n);
        System.out.printf("Results - save floor = %d, dead cats = %d", floor, countCats);
      }
    public static int findFloor(int min, int max) {

        if(n==1) return 1;

        if (max <= min) {
            boolean b;
            if(map.containsKey(min)) b=map.get(min);
            else b=isAlive(min);
            return b ? min : min - 1;
        }
        int middle = (max+min)/2;
        boolean isAlive =  isAlive(middle);
        System.out.printf("min - %s, middle - %s, max - %s, isAlive - %s %n", min, middle, max, isAlive);

        if(isAlive) {
            System.out.printf("min = %d, max = %d %n", middle+1, max );
            return findFloor(middle+1, max);
        } else {
            System.out.printf("min = %d, max = %d %n", min, middle-1);
            return findFloor(min, middle-1);
        }
    }

    static boolean isAlive(int floor)
    {
        boolean res = (floor < maxSaveFloor+1);
        map.put(floor, res);
        countCats++;
        return res;
    }
}