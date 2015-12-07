package ua.luckydev;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

//Тести методы нашего Валидатора
public class ValidatorTest
{
    Validator validator = new Validator();

    @Test
    public void testValidation() throws Exception
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

        boolean rightMessage = validator.validation("InstructionMessage A MZ89 5678 50 2015-03-05T10:04:56.012Z".split(" "));
        boolean wrongMessage = validator.validation("InstructionMessage W MZ89 5678 50 2015-03-05T10:04:56.012Z".split(" "));

        assertTrue("Check rightMessage", rightMessage);
        assertFalse("Check wrongMessage", wrongMessage);

        System.out.println("Ending test " + new Object(){ }.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void testCheckInstructionType() throws Exception
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

        boolean resA = validator.checkInstructionType("A");
        boolean resB = validator.checkInstructionType("B");
        boolean resC = validator.checkInstructionType("C");
        boolean resD = validator.checkInstructionType("D");
        boolean resE = validator.checkInstructionType("E");
        boolean resAA = validator.checkInstructionType("AA");

        assertTrue("Check A (true for A, B, C, D)", resA);
        assertTrue("Check B (true for A, B, C, D)", resB);
        assertTrue("Check C (true for A, B, C, D)", resC);
        assertTrue("Check D (true for A, B, C, D)", resD);
        assertFalse("Check E (true for A, B, C, D)", resE); //another character
        assertFalse("Check AA (true for A, B, C, D)", resAA); //double character

        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void testProductCode() throws Exception
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

        boolean resAA11 = validator.checkProductCode("AA11");
        boolean resAA11A = validator.checkProductCode("AA11A"); //+1 character
        boolean resaa11 = validator.checkProductCode("aa11"); //small character
        boolean resAAAA = validator.checkProductCode("AAAA"); //4 character

        assertTrue("Check AA11 (true for AB12)", resAA11);
        assertFalse("Check AA11A (true for A, B, C, D)", resAA11A);
        assertFalse("Check aa11 (true for A, B, C, D)", resaa11);
        assertFalse("Check AAAA (true for A, B, C, D)", resAAAA);

        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void testCheckQuantity() throws Exception
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

        boolean res100 = validator.checkQuantity("100");
        boolean maxInt = validator.checkQuantity(new String().valueOf(Integer.MAX_VALUE));
        boolean maxIntPlus1 = validator.checkQuantity(new String().valueOf(Integer.MAX_VALUE+1));
        boolean zero = validator.checkQuantity("0");


        assertTrue("Check res100 (true for Integer, 0 < n)", res100);
        assertTrue("Check maxInt (true for Integer, 0 < n)", maxInt);
        assertFalse("Check maxIntPlus1 (true for Integer, 0 < n)", maxIntPlus1);
        assertFalse("Check zero (true for Integer, 0 < n)", zero);

        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void testCheckUOM() throws Exception
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

        boolean res100 = validator.checkUOM("100");
        boolean zero = validator.checkUOM("0");
        boolean maxPlus1 = validator.checkUOM("256");
        boolean minus = validator.checkUOM("-1");


        assertTrue("Check 100 (true for Integer, 0 <= n < 256)", res100);
        assertTrue("Check zero (true for Integer, 0 <= n < 256)", zero);
        assertFalse("Check maxPlus1 (true for Integer, 0 <= n < 256)", maxPlus1);
        assertFalse("Check minus (true for Integer, 0 <= n < 256)", minus);

        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void testCheckDate() throws Exception
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        Date unixDateD = new Date(0);
        String currentDateString = simpleDateFormat.format(date);
        String unixDateString = simpleDateFormat.format(unixDateD);
        String currentDateStringPlus1min = simpleDateFormat.format(new Date(date.getTime()+60*1000));

        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

        boolean rightDate = validator.checkDate("2015-03-05T10:04:56.012Z");
        boolean currentDate = validator.checkDate(currentDateString);
        boolean unixDate = validator.checkDate(unixDateString);
        boolean currentDatePlus1min = validator.checkDate(currentDateStringPlus1min);

        assertTrue("Check rightDate (true for Unix epoch < t <= current time)", rightDate);
        assertTrue("Check currentDate (true for Unix epoch < t <= current time)", currentDate);
        assertFalse("Check unixDate (true for Unix epoch < t <= current time)", unixDate);
        assertFalse("Check currentDatePlus1min (true for Unix epoch < t <= current time)", currentDatePlus1min);

        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
}