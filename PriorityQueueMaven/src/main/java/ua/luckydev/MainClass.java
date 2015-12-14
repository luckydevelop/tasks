package ua.luckydev;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Just testing
class MainClass
{
    public static void main(String[] args)
    {
        new MessageReceiverImpl().receive("InstructionMessage B MZ89 5678 50 2015-03-05T10:04:56.012Z");
        PriorityQueue<InstructionMessage> priorityQueue = new PriorityQueue<InstructionMessage>();
        InstructionQueue instructionQueue = new InstructionQueue(priorityQueue);

        List<String> messageList = new ArrayList<String>();
        messageList.add("InstructionMessage B MZ89 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage D MZ90 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage C MZ91 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage A MZ92 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage A MZ93 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage D MZ94 5678 50 2015-03-05T10:04:56.012Z");

        messageList.add("InstructionMessage A MZ01 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage D MZ02 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage B MZ03 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage C MZ04 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage A MZ05 5678 50 2015-03-05T10:04:56.012Z");

        System.out.println("Обход списка");
        for (String s : messageList)
        {
            new MessageReceiverImpl().receive(s);
            instructionQueue.enqueue(MessageReceiverImpl.instructionMessage);
            System.out.println(s);
        }

        System.out.println("Обход очереди");
        for (InstructionMessage message : priorityQueue)
        {
            System.out.println(message);
        }

        System.out.println("Голова очереди - " + instructionQueue.peek());

        System.out.println("Удаляем очередь");
        for (int i=instructionQueue.count(); i>0; i--)
        {
           InstructionMessage is = instructionQueue.dequeue();
            System.out.println(is);
        }
   }
}
