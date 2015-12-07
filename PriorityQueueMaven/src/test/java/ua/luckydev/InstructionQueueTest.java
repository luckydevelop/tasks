package ua.luckydev;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ua.luckydev.InstructionMessage;

import java.util.ArrayList;
import java.util.List;

//��������� ����� InstructionQueue
public class InstructionQueueTest
{
    InstructionQueue instructionQueue = new InstructionQueue();
    MessageReceiverImpl messageReceiver = new MessageReceiverImpl();//����� void receive ����� ������ ������ ������ InstructionMessage
    InstructionMessage instructionMessageA;  //���������� ��� �����
    InstructionMessage instructionMessageD;
    InstructionMessage instructionMessageB;
    InstructionMessage instructionMessageC;
    InstructionMessage instructionMessageA2;

    @Test
    public void testisEmpty() throws Exception
    {
        System.out.println("Starting test " + new Object(){ }.getClass().getEnclosingMethod().getName());

        boolean isEmpty = instructionQueue.isEmpty();
        assertTrue("Check isEmpry QUEUE", isEmpty); //Test isEmpty() when Queue is empty

        int numberMessages = instructionQueue.count();
        assertEquals("Must be Zero messages", 0, numberMessages);// Tests method count()

        messageReceiver.receive("InstructionMessage A MZ01 5678 50 2015-03-05T10:04:56.012Z");
        instructionMessageA=messageReceiver.instructionMessage; // �������������� ����������

        messageReceiver.receive("InstructionMessage D MZ02 5678 50 2015-03-05T10:04:56.012Z");
        instructionMessageD=messageReceiver.instructionMessage;

        messageReceiver.receive("InstructionMessage B MZ03 5678 50 2015-03-05T10:04:56.012Z");
        instructionMessageB=messageReceiver.instructionMessage;

        messageReceiver.receive("InstructionMessage C MZ04 5678 50 2015-03-05T10:04:56.012Z");
        instructionMessageC=messageReceiver.instructionMessage;

        messageReceiver.receive("InstructionMessage A MZ05 5678 50 2015-03-05T10:04:56.012Z");
        instructionMessageA2=messageReceiver.instructionMessage;

        instructionQueue.enqueue(instructionMessageA); //��������� �������� � �������
        instructionQueue.enqueue(instructionMessageD);
        instructionQueue.enqueue(instructionMessageB);
        instructionQueue.enqueue(instructionMessageC);
        instructionQueue.enqueue(instructionMessageA2);

        boolean isNotEmpty = instructionQueue.isEmpty();
        assertFalse("Check isNotEmpty QUEUE", isNotEmpty); //Test isEmpty() when Queue is not empty

        numberMessages = instructionQueue.count();
        assertEquals("Must be 5 messages", 5, numberMessages);  // Tests method count() when Que is not empty

        //� ���� ������ ����� ����������� ��������� �� ������� ���� ��������� ��������������� ������
        List<InstructionMessage> instructionMessagesList = new ArrayList<InstructionMessage>();

       //����� � ������� ����� ��������� � ������� ��������������� �������
        List<InstructionMessage> instructionMessagesListSorted = new ArrayList<InstructionMessage>();

        //��������� ������ instructionMessagesListSorted
        instructionMessagesListSorted.add(instructionMessageA);
        instructionMessagesListSorted.add(instructionMessageA2);
        instructionMessagesListSorted.add(instructionMessageB);
        instructionMessagesListSorted.add(instructionMessageD);
        instructionMessagesListSorted.add(instructionMessageC);

        //��������� ������ instructionMessagesList
        for (int i=instructionQueue.size(); i>0; i--)
        {
            instructionMessagesList.add(instructionQueue.dequeue());
        }

        boolean equalQueue = instructionMessagesList.equals(instructionMessagesListSorted);
        assertTrue("Test whether priority in QUEUE is Ok", equalQueue); //Test whether priority in QUEUE is Ok

        System.out.println("Ending test " + new Object() { }.getClass().getEnclosingMethod().getName());

    }
}
