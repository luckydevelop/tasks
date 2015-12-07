package ua.luckydev;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lucky on 04.12.2015.
 */
public class MessageReceiverImpl implements MessageReceiver
{
    public static InstructionMessage instructionMessage; //тут будет храниться текущий экземпляр InstructionMessage, т.к.
    static boolean validMessage = false; // метод receive возвращает - void

    public void createInstance(String[] arrayMessage)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try
        {
            instructionMessage = new InstructionMessage(arrayMessage[0], arrayMessage[1], arrayMessage[2],
              new Integer(arrayMessage[3]), new Integer(arrayMessage[4]), simpleDateFormat.parse(arrayMessage[5]));
        }
        catch (ParseException e) //ловим исключение, которое требует обработать SimpleDateFormat
        {
            e.printStackTrace();
        }
    }


    @Override
    public void receive(String message) //This method should build an instance of type InstructionMessage
    {
        String[] arrayMessage = message.split(" ");

            if (Validator.validation(arrayMessage)) //проверяем валидно ли сообщение
            {
                createInstance(arrayMessage); //создаём объект InstructionMessage
                validMessage = true; //при успешной проверки присваиваем значени переменной в true
            }
            else
            {
                validMessage = false;
                //Если валидация не пройдена, то выбрасывается исключение
                throw new IllegalArgumentException("Invalid InstructionMessage. Please check you InstructionMessage");
            }
    }
}
