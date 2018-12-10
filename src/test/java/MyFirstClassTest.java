import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import junitparams.JUnitParamsRunner;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MyFirstClassTest {

    private double sum(final double a, final double b)
    {
        return a+b;
    }
    MyFirstClass newClass = new MyFirstClass();
    String name = "Teodor";
    Integer age = 21;

    List<String> testList = new ArrayList<>();

    public String returnString()
    {
        return "Name is: Teodor, age is : 21";
    }

    /**
     * This would be the method for adding an Object to the list
     * @param something String to be added to the list
     * @author Teodor
     */
    public void addData(String something)
    {
        testList.add(something);
    }

    @Test
    public void shouldReturnSum()
    {
        assertEquals(5.55, sum(5, 0.55), 0);
    }

    @Test
    public void checkIfListIsEmpty()
    {
        assertEquals(0, testList.size());
    }

    /**
     * This test checks if the number of objects in the List is 1.
     */
    @Test
    public void checkIfListHasObjectsInAfterAdding()
    {
        addData("add me");
        assertEquals(1, testList.size());
    }

    @Test
    public void checkIfEmptyAfterClearing()
    {
        testList.clear();
        assertEquals(0, testList.size());
    }

    private static final Object[] getInvalidAmount() {
        return new Integer[][]{{-123}, {-2}, {-1}};
    }
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void CheckForIllegalArgumentException(int invalidAmount)
    {
        new Money(invalidAmount, "USD");
    }


    // WEEK 2//

    public long addUp(long... operands)
    {
        long toReturn = operands[0];
        for(int i = 1; i < operands.length; i++)
        {
            toReturn += operands[i];
        }
        return toReturn;
    }

    public long subTract(long... operands)
    {
        long toReturn = operands[0];
        for(int i = 1; i < operands.length; i++)
        {
            toReturn -= operands[i];
        }
        return toReturn;
    }

    @Test public void testAdd() {
        fail("Not yet impplemented");
    }

    @Test
    public void testSubtract()
    {
        long result = 10 + 123 + (-13) + 31;

        assertEquals(result, addUp(10, 123, -13, 31));

        result = 100 + 1234;

        assertEquals(result, addUp(100, 1234));

        result = 0;


        assertEquals(result, addUp(0));
    }



}