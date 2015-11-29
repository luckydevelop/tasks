package ua.luckydev.zadachki.SingleList;

/**
 * Created by Lucky on 28.11.2015.
 */

//????????????? ?????? - ???????? ?????????????????? ????????? ?? ????????

public class SingleList
{
    ListElement head;
    ListElement tail;

    public void add(int data)
    {
        ListElement element = new ListElement();
        element.data = data;

        if(head==null)
        {
            head=element;
            tail=element;
        }
        else
        {
            tail.nextElement = element;
            tail=element;

        }

    }

    @Override
    public String toString()
    {
        return "head - "+head.data + " tail - " + tail.data;
    }

    // 1 2 3 4 5
}
