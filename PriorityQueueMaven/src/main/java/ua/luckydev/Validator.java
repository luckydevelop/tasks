package ua.luckydev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// ¬ данном классе проходит валидаци€ сообщени€
public class Validator
{

    public static boolean validation(String[] arrayMessage)
    {
        if ((arrayMessage.length == 6) && (arrayMessage[0].equals("InstructionMessage")) && (checkInstructionType(arrayMessage[1])) &&
                (checkProductCode(arrayMessage[2]) && checkQuantity(arrayMessage[3]) && checkUOM(arrayMessage[4]) && checkDate(arrayMessage[5])))
            return true;

        else return false;
    }

    public static boolean checkProductCode(String productCode) //String of form AB12 (two uppercase letters followed by two digits)
    {
        if (productCode.matches("[A-Z]{2}\\d{2}"))
        {
            return true;
        } else return false;
    }

    public static boolean checkInstructionType(String instruction) //One of A, B, C or D
    {
        if (instruction.matches("[A|B|C|D]{1}"))
        {
            return true;
        } else return false;
    }

    public static boolean checkQuantity(String quantityString)  //Integer, 0 < n
    {
        if (quantityString.matches("\\d{1,10}"))
        {
            Integer quantity = new Integer(quantityString);
            if (quantity > 0 && quantity <= Integer.MAX_VALUE) return true;
            else return false;
        } else return false;
    }

    public static boolean checkUOM(String uomString)   //Integer, 0 <= n < 256
    {
        if (uomString.matches("\\d{1,3}"))
        {
            Integer uom = new Integer(uomString);
            if (uom >= 0 && uom < 256) return true;
            else return false;
        } else return false;
    }

    public static boolean checkDate(String dateString) //Unix epoch < t <= current time
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Date timestamp = null;
        try
        {
            timestamp = simpleDateFormat.parse(dateString);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        Date currentDate = new Date();
        Date unixDate = new Date(0);

        if (((timestamp.compareTo(currentDate) == -1) || (timestamp.compareTo(currentDate) == 0))
                && (timestamp.compareTo(unixDate) == 1))
        {
            return true;
        } else
        {
            return false;
        }
    }

}
