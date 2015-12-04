package ua.luckydev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lucky on 02.12.2015.
 */
public class InstructionMessage implements MessageReceiver, Comparable<InstructionMessage>
{
    public static InstructionMessage instructionMessage;
    static boolean validMessage = false;

    String message;
    String instructionType;
    String productCode;
    Integer quantity;
    Integer uom;
    Date timestamp;

    public void createInstance(String[] arrayMessage)
    {
        instructionMessage.productCode = arrayMessage[2];
        instructionMessage.message = arrayMessage[0];
    }

//    public static void main(String[] args)
//    {
//        InstructionMessage instructionMessage = new InstructionMessage();
//        instructionMessage.receive("InstructionMessage A MZ89 5678 50 2015-03-05T10:04:56.012Z");
//    }

    @Override
    public void receive(String message)
    {
        instructionMessage = new InstructionMessage();
        String[] arrayMessage = message.split(" ");

        try
        {
            if (validation(arrayMessage))
            {
                //System.out.println(instructionType);
                createInstance(arrayMessage);
                validMessage = true;
              //  System.out.println(validMessage);
            } else
            {
                validMessage = false;
              //  System.out.println(validMessage);
                throw new IllegalArgumentException("Invalid InstructionMessage. Please check you InstructionMessage");
            }
        } catch (ParseException e)
        {
            validMessage = false;
            System.out.println("***");
            e.printStackTrace();
        }
    }

    public boolean validation(String[] arrayMessage) throws ParseException
    {
        if ((arrayMessage.length == 6) && (arrayMessage[0].equals("InstructionMessage")) && (checkInstructionType(arrayMessage[1])) &&
                (arrayMessage[2].matches("[A-Z]{2}\\d{2}")) && checkQuantity(arrayMessage[3]) && checkUOM(arrayMessage[4]) && checkDate(arrayMessage[5]))
            return true;

        else return false;
    }

    public boolean checkInstructionType(String instruction)
    {
        if (instruction.matches("[A|B|C|D]{1}"))
        {
            instructionMessage.instructionType = instruction;
            return true;
        } else return false;
    }

    public boolean checkQuantity(String quantityStrin)
    {
        if (quantityStrin.matches("\\d{1,10}"))
        {
            instructionMessage.quantity = new Integer(quantityStrin);
            if (instructionMessage.quantity > 0 && instructionMessage.quantity < Integer.MAX_VALUE) return true;
            else return false;
        } else return false;
    }

    public boolean checkUOM(String uomString)
    {
        if (uomString.matches("\\d{1,3}"))
        {
            instructionMessage.uom = new Integer(uomString);
            if (instructionMessage.uom >= 0 && instructionMessage.uom < 256) return true;
            else return false;
        } else return false;
    }

    public boolean checkDate(String dateString) throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        instructionMessage.timestamp = simpleDateFormat.parse(dateString); //ParseExeption
        Date currentDate = new Date();
        Date unixDate = new Date(0);


        if (((instructionMessage.timestamp.compareTo(currentDate) == -1) || (instructionMessage.timestamp.compareTo(currentDate) == 0))
                && (instructionMessage.timestamp.compareTo(unixDate) == 1))
        {
            return true;
        } else
        {
            return false;
        }
    }


    @Override
    public int compareTo(InstructionMessage message)
    {
//        if ((instructionType.equals("C") || instructionType.equals("D"))&& (message.instructionType.equals("C") || message.instructionType.equals("D")))
//        return 0;

     //   else return instructionType.compareTo(message.instructionType);
        return instructionType.compareTo(message.instructionType);
    }


    @Override
    public String toString()
    {
        return "InstructionMessage{" +
                "message='" + message + '\'' +
                ", instructionType='" + instructionType + '\'' +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", uom=" + uom +
                ", timestamp=" + timestamp +
                '}';
    }
}

