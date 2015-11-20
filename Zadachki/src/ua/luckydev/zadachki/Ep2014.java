package ua.luckydev.zadachki;

import java.util.*;

/**
 * Created by Lucky on 14.09.2015.
 */
//public class Epam2014 {
//
//    public static void main(String[] args) {
//        int[] array = {3, 5, 3, 2, 5, 7, 8, 25, 34, 5, -2, 8, 8, -2, -2, -2, 0};
//        sort(array);
//        for (int i : array) {
//            System.out.println(i);
//        }
//    }
//
//    private static int[] sort(int[] array) {
//        SortedMap <Integer, Integer> map = new TreeMap<>();
//        for (int i : array) {
//            map.put(i, 0);
//        }
//
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int count = 0;
//            for (int i : array) {
//                if (i == entry.getKey()) count += 1;
//            }
//            map.put(entry.getKey(), count);
//        }
//
//       List<Map.Entry<Integer, Integer>>list= new ArrayList<>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//
//                Integer val1 = o1.getValue();
//                Integer val2 = o2.getValue();
//                if(val1!=val2) return val2.compareTo(val1);
//                else
//                {
//                    Integer key1 = o1.getKey();
//                    Integer key2 = o2.getKey();
//                    return key2.compareTo(key1);
//                }
//            }
//        });
//
//        ArrayList<Integer> listFinal = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            Map.Entry<Integer, Integer> entry =  list.get(i);
//            int key = entry.getKey();
//            int value = entry.getValue();
//
//            for (int j = 0; j < value; j++) {
//                listFinal.add(key);
//            }
//        }
//
//       Integer[] arrayFinal = listFinal.toArray(new Integer[listFinal.size()]);
//        Arrays.asList();
//
//        for (int i = 0; i < arrayFinal.length; i++) {
//            array[i] = arrayFinal[i];
//
//        }
//
//        return array;
//    }
//}


public class Ep2014
{

    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, -2, -2, 3, 3, 5, 7, 1, -2, -2};
        sort(array);
        for(int n : array) System.out.println(n);

    }

    public static int[] sort(int[] array)
    {

        SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for(int n : array) map.put(n, 0);

        for( Map.Entry<Integer, Integer> entry  : map.entrySet())
        {
            Integer key = entry.getKey();
            int count=0;

            for(int n : array) if (n==key) count++;

            map.put(key, count);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
                {
                    @Override
                   public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2)
                    {
                        Integer value1 = entry1.getValue();
                        Integer value2 = entry2.getValue();
                        return value2.compareTo(value1);
                    }
                }
        );

        List<Integer> listFinal = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : list )
        {

            for(int i=0; i<entry.getValue(); i++)
            {
                listFinal.add(entry.getKey());
            }
        }

        for(int i =0; i<listFinal.size(); i++)
        {
            array[i] = listFinal.get(i);
        }

        return array;


    }




}


