import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class Week3MockitoTesting {
    //WEEK 3//


    private static final Object[] getMoney() {
        return new Object[]{
                new Object[] {10, "DOLLAR"},
                new Object[] {10, "EURO"}
        };
    }


    @Test
    @Parameters(method = "getMoney")
    public void CheckForIllegalArgumentException(int amount, String currency)
    {
        Money money = new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    /**
     *
     */
    @Test
    public void SomeTest()
    {

    }



    private Car myFerrari = mock(Car.class);

    @Test
    public void MockitoTestIfCarIsACar(){
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void MockitoTestingCar()
    {
        myFerrari = mock(Car.class);
        myFerrari.needsFuel();
    }




}
