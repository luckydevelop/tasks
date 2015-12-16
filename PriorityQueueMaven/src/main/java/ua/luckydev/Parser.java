package ua.luckydev;

import java.util.Date;

public class Parser
{
//    private String message;
//    private String instructionType;
//    private String productCode;
//    private Integer quantity;
//    private Integer uom;
//    private Date timestamp;

    String message;
    private String regExSprit = " ";

    public Parser(String message)
    {
        this.message = message;
    }

    String[] messageInArray = message.split(regExSprit);
}
