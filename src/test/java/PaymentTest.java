import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void testEquals() {
        GregorianCalendar date = new GregorianCalendar(2020, Calendar.MARCH, 4);
        Payment x = new Payment("Толик",560, new GregorianCalendar());
        Payment y = new Payment("Толик", 560, date);
        boolean ans = false;
        ans = y.equals(x);
        assertEquals(false, ans);
        Payment x1 = new Payment("Толик",560, date);
        Payment y1 = new Payment("Толик", 560, date);
        ans = y1.equals(x1);
        assertEquals(true, ans);
        Payment x2 = new Payment("Толик",56, date);
        Payment y2 = new Payment("Толик", 560, date);
        ans = y2.equals(x2);
        assertEquals(false, ans);
        Payment x3 = new Payment("Толик",560, date);
        Payment y3 = new Payment("Трен", 560, date);
        ans = y3.equals(x3);
        assertEquals(false, ans);
    }

    @Test
    public void testToString() {
        Payment x = new Payment("Толик",560, new GregorianCalendar());
        System.out.println(x.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumInvalid() {
        Payment payment = new Payment("name", -42.0, new GregorianCalendar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameInvalid() {
        Payment payment = new Payment(null, 100.0, new GregorianCalendar());
    }
}