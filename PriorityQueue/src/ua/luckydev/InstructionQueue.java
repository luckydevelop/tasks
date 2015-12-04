package ua.luckydev;

import java.util.PriorityQueue;

/**
 * Created by Lucky on 02.12.2015.
 */
public class InstructionQueue<InstructionMessage> extends PriorityQueue<InstructionMessage>
{
    //Adds a message to the queue
    void enqueue(InstructionMessage message)
    {
        add(message);
    }

    //Removes the highest-priority message from the queue and returns it
    InstructionMessage dequeue()
    {
        return poll();
    }

   // Returns the highest-priority message from the queue, without removing it
//    InstructionMessage peek()
//    {
//      return peek();
//    }

    //Returns the number of messages currently on the queue
    int count()
    {
        return size();
    }

    //Returns true if the queue is empty, false otherwise
//    boolean isEmpty()
//    {
//       if (size()==0) return true;
//        else return false;
//    }


}
