package ua.luckydev;

import java.util.Date;
import java.util.PriorityQueue;

//public class InstructionQueue extends PriorityQueue
// мотод boolean isEmpty() и InstructionMessage peek() не уже реализованы в PriorityQueue по-умолчанию
public class InstructionQueue extends PriorityQueue<InstructionMessage>
{

    //Adds a message to the queue
    public void enqueue(InstructionMessage message)
    {
        message.timeStampQueue = new Date().getTime()+count(); //инициализируем поле, которое будет использоваться в
        add(message);                           // сортировке для обеспечения ФИФО у объектов с одинаковым InstructionType
    }


    //Removes the highest-priority message from the queue and returns it
    InstructionMessage dequeue()
    {
        return poll(); //т.к. подобный метод уже реализовон, но с другим названием, перенаправляем вызов
    }

    //Returns the number of messages currently on the queue
    int count()  //т.к. подобный метод уже реализовон, но с другим названием, перенаправляем вызов
    {
        return size();
    }





}
