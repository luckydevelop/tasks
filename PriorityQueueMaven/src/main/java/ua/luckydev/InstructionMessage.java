package ua.luckydev;

import java.util.Date;

//����� � ������� ��������������� �������� ������������ ���������
public class InstructionMessage implements Comparable<InstructionMessage>
{
    String message;
    String instructionType;
    String productCode;
    Integer quantity;
    Integer uom;
    Date timestamp;
    Long timeStampQueue; //���������� ��� ����, ����� ���� ���� ��� ��������� � ���������� instructionType
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

    @Override
    public int compareTo(InstructionMessage message) // �������������� ����� �������� ��
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
    public String toString() // ��� �������� ��������� ����������� ������
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

    public void count() //count ��� ����, ����� ��������� timestamp �� �������� ����� ��������� ���. ���������� � Priority Queue
    {
        if(count==100)
        {
            count=0;
        }
        else count++;
    }
}

