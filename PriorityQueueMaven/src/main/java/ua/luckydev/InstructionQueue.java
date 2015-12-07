package ua.luckydev;

import java.util.Date;
import java.util.PriorityQueue;

//public class InstructionQueue extends PriorityQueue
// ����� boolean isEmpty() � InstructionMessage peek() �� ��� ����������� � PriorityQueue ��-���������
public class InstructionQueue extends PriorityQueue<InstructionMessage>
{

    //Adds a message to the queue
    public void enqueue(InstructionMessage message)
    {
        message.timeStampQueue = new Date().getTime()+count(); //�������������� ����, ������� ����� �������������� �
        add(message);                           // ���������� ��� ����������� ���� � �������� � ���������� InstructionType
    }


    //Removes the highest-priority message from the queue and returns it
    InstructionMessage dequeue()
    {
        return poll(); //�.�. �������� ����� ��� ����������, �� � ������ ���������, �������������� �����
    }

    //Returns the number of messages currently on the queue
    int count()  //�.�. �������� ����� ��� ����������, �� � ������ ���������, �������������� �����
    {
        return size();
    }





}
