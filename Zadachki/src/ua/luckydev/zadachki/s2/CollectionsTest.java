package ua.luckydev.zadachki.s2;

import java.util.*;

public class CollectionsTest
{
    static String[] aaray1 = {"aaa", "bb", "cc", "d", "eee", "f", "gg"};
    static String[] aaray2 = {"aaa", "bbbb", "cc", "d", "eeee", "ff", "cc", "ff"};

    public static void main(String[] args)
    {
//        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i);
//        }
//        System.out.println(list);


        Collection<String> collection1 = new HashSet<String>(Arrays.asList(aaray1));
        Collection<String> collection2 = new HashSet<String>(Arrays.asList(aaray2));

        ArrayList<String> list2 = new ArrayList<String>(collection2);

        System.out.println(collection1.size()); //7
        System.out.println(collection2.size());//6

        System.out.println("****");

//        for (int i = 0; i < list2.size(); i++)
//        {
//            System.out.println(list2.size());
//            String s =  list2.get(i);
//            System.out.println(s);
//            list2.remove(i);
//            i--;
//
//        }
//        System.out.println(list2);

        for(String s : collection2)
        {
            //System.out.println(s.length());
            if(s.length()>3)
            {
                System.out.println(s);
                collection2.remove(s);
            }
        }

        System.out.println(collection2.size());


    }
}
