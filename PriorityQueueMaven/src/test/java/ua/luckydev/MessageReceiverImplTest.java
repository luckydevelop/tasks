package ua.luckydev;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

//Тестим выбрасывается ли нужное сообщение при не верном формате сообщения
public class MessageReceiverImplTest
{
    MessageReceiver messageReceiver = new MessageReceiverImpl();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreateInstance() throws IllegalArgumentException
    {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid InstructionMessage. Please check you InstructionMessage");
       messageReceiver.receive("InstructionMessage W MZ89 5678 50 2015-03-05T10:04:56.012Z");

    }
}