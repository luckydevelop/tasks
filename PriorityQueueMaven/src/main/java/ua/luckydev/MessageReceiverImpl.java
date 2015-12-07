package ua.luckydev;

import java.text.ParseException;
import java.text.SimpleDateFormat;


class MessageReceiverImpl implements MessageReceiver
{
    static InstructionMessage instructionMessage; //тут будет храниться текущий экземпляр InstructionMessage, т.к.

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

       public void receive(String message) //This method should build an instance of type InstructionMessage
    {
        String[] arrayMessage = message.split(" ");

            if (Validator.validation(arrayMessage)) //проверяем валидно ли сообщение
            {
                createInstance(arrayMessage); //создаём объект InstructionMessage
            }
            else
            {
                //Если валидация не пройдена, то выбрасывается исключение
                throw new IllegalArgumentException("Invalid InstructionMessage. Please check you InstructionMessage");
            }
    }
}
