package ua.luckydev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucky on 03.12.2015.
 */
public class MainClass
{
    public static void main(String[] args)
    {
        InstructionMessage instructionMessage = new InstructionMessage();
        InstructionQueue<InstructionMessage> instructionQueue = new InstructionQueue<InstructionMessage>();

        List<String> messageList = new ArrayList<String>();
        messageList.add("InstructionMessage B MZ89 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage D MZ90 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage A MZ91 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage A MZ92 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage A MZ93 5678 50 2015-03-05T10:04:56.012Z");
        messageList.add("InstructionMessage D MZ94 5678 50 2015-03-05T10:04:56.012Z");


        for (String s : messageList)
        {
            instructionMessage.receive(s);
            if(instructionMessage.validMessage) instructionQueue.enqueue(instructionMessage.instructionMessage);
        }

        System.out.println("Обход очереди");
        for (InstructionMessage message : instructionQueue)
        {
            System.out.println(message);
        }

        System.out.println("Голова очереди - " + instructionQueue.peek());

//        System.out.println(instructionQueue.count());
//        System.out.println("Голова очереди - " + instructionQueue.poll());
//        System.out.println("Удаляем голову очереди - " + instructionQueue.dequeue());
//        System.out.println(instructionQueue.poll());
//
//        System.out.println("***************");
        System.out.println("Удаляем очередь");
        for (int i=6; i>0; i--)
        {
            InstructionMessage is = instructionQueue.dequeue();
            System.out.println(is);
        }



//        instructionMessage.receive("InstructionMessage A MZ89 5678 50 2015-03-05T10:04:56.012Z");
//        if(instructionMessage.validMessage) instructionQueue.add(instructionMessage.instructionMessage);

    }

}
