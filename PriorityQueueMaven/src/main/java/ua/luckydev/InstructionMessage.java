package ua.luckydev;

import java.util.Date;

//Класс в котором непосредственно хранится распарсинное сообщение
class InstructionMessage implements Comparable<InstructionMessage>
{
    private String message;
    private String instructionType;
    private String productCode;
    private Integer quantity;
    private Integer uom;
    private Date timestamp;
    private Long timeStampQueue; //используем для того, чтобы было ФИФО для сообщений с одинаковым instructionType

    public void setTimeStampQueue(Long timeStampQueue)
    {
        this.timeStampQueue = timeStampQueue;
    }

    InstructionMessage(String message, String instructionType, String productCode, Integer quantity, Integer uom, Date timestamp)
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
}

