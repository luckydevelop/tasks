package ua.luckydev;

import java.text.ParseException;
import java.text.SimpleDateFormat;


class MessageReceiverImpl implements MessageReceiver
{
    InstructionMessage instructionMessage;
    Validator validator;
    Parser parser;
    private final String regExForSplit = " ";

    public MessageReceiverImpl(Parser parser)
    {
        this.parser = parser;
    }

    void createInstance(String[] arrayMessage)
    {
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try
        {
            instructionMessage = new InstructionMessage(arrayMessage[0], arrayMessage[1], arrayMessage[2],
              new Integer(arrayMessage[3]), new Integer(arrayMessage[4]), simpleDateFormat.parse(arrayMessage[5]));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

       public void receive(String message)
    {
        Parser parser = new Parser(message);

            if (Validator.validation(arrayMessage))
            {
                createInstance(arrayMessage);
            }
            else
            {
                throw new IllegalArgumentException("Invalid InstructionMessage. Please check you InstructionMessage");
            }
    }
}
