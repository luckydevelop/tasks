package ua.luckydev;

import java.util.Date;
import java.util.PriorityQueue;

//public class InstructionQueue extends PriorityQueue
// мотод boolean isEmpty() и InstructionMessage peek() не уже реализованы в PriorityQueue по-умолчанию
class InstructionQueue
{
    PriorityQueue<InstructionMessage> priorityQueue;

    public InstructionQueue(PriorityQueue<InstructionMessage> priorityQueue)
    {
        this.priorityQueue = priorityQueue;
    }

    void enqueue(InstructionMessage message)
    {
        message.setTimeStampQueue(System.nanoTime());
        priorityQueue.add(message);
    }

    InstructionMessage dequeue()
    {
        return priorityQueue.poll();
    }

    int count()
    {
        return priorityQueue.size();
    }

    InstructionMessage peek()
    {
        return priorityQueue.peek();
    }

    boolean isEmpty()
    {
        return priorityQueue.isEmpty();
    }
}
