package ua.luckydev;

import java.util.Date;

//Класс в котором непосредственно хранится распарсинное сообщение
public class InstructionMessage implements Comparable<InstructionMessage>
{
    String message;
    String instructionType;
    String productCode;
    Integer quantity;
    Integer uom;
    Date timestamp;
    Long timeStampQueue; //используем для того, чтобы было ФИФО для сообщений с одинаковым instructionType
    static int count;

    public InstructionMessage(String message, String instructionType, String productCode, Integer quantity, Integer uom, Date timestamp)
    {
        this.message = message;
        this.instructionType = instructionType;
        this.productCode = productCode;
        this.quantity = quantity;
        this.uom = uom;
        this.timestamp = timestamp;
    }

   // @Override
    public int compareTo(InstructionMessage message) // Переопределяем метод согласно ТЗ
    {
       int res;

        res = instructionType.compareTo(message.instructionType);
        if((instructionType.equals("C") || instructionType.equals("D"))&&
                (message.instructionType.equals("C") || message.instructionType.equals("D")))
            res=0;
        if (res==0)
        {
            res = timeStampQueue.compareTo(message.timeStampQueue);
        }
        return res;    }

    @Override
    public String toString() // для удобства текстовое отображение класса
    {
        return "InstructionMessage{" +
                "message='" + message + '\'' +
                ", instructionType='" + instructionType + '\'' +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", uom=" + uom +
                ", timestamp=" + timestamp +
                ", timeStampQueue=" + timeStampQueue +
                '}';
    }

    public void count() //count для того, чтобы отличался timestamp по которому будет проходить доп. сортировка в Priority Queue
    {
        if(count==100)
        {
            count=0;
        }
        else count++;
    }
}

