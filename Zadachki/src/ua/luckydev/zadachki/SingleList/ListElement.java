package ua.luckydev.zadachki.SingleList;

/**
 * Created by Lucky on 28.11.2015.
 */

//Класс - элемент однозвязанного списка

public class ListElement
{
    int data;
    ListElement nextElement;

    @Override
    public String toString()
    {
        return "Element number "+data;
    }
}
