package ua.luckydev.zadachki.SingleList;

/**
 * Created by Lucky on 29.11.2015.
 */
/*
public class Badsolution
{
    public class InvertList() // () - Лишние
    {
        public static void Main (String args[]) // - (String[] args)

        {
            SingleList sl = new SingleList(); //взял вымешленный односвязанный список

            sl.add(1); //добавил элементы
            sl.add(2);
            sl.add(3);
            sl.add(4);

            sl = invert(sl);
        }

    public static SinglList invert(SingleList sl) // SinglEList
    {
        ListElement element = sl.head;

        while(element!=sl.tail)
        {
            sl.tail.next = sl.head;
            sl.head = sl.tail;
            sl.tail = findTail(sl, tail);
        }

        tail.next = null;

        // нет return
    }

    public ListElement findTail(SingleList sl, ListElement tail )
    {
        ListElement element = sl.head;

        while(element.next!=tail)
        {
            element = element.next;
        }

        return element;

    }
}
}
*/
