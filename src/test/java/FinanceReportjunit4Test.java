import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class FinanceReportjunit4Test {

    FinanceReport financeReport = new FinanceReport("Sergey", new GregorianCalendar(2021, Calendar.FEBRUARY, 10),
            new Payment("Pyaterochka", 100.2, new GregorianCalendar(2010, Calendar.FEBRUARY, 20)),
            new Payment("Magnit", 99.99, new GregorianCalendar(2019, Calendar.MARCH, 2)),
            new Payment("Perekrestok", 1.2, new GregorianCalendar(2020, Calendar.JANUARY, 1)));


    /*
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIndex() {
        financeReport.getPayment(financeReport.getArr().length + 100);
    }

     */




    @Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(financeReport);
        copy.setPayment(0, new Payment("name", 10.1, new GregorianCalendar()));
        assertNotEquals(copy.getPayment(0), financeReport.getPayment(0));
    }

    @Test
    public void testToString(){
        FinanceReport copyFinanceReport = new FinanceReport(financeReport);
        System.out.println( copyFinanceReport.toString());
    }

    @Test
    public void testEquals(){
        FinanceReport copyFinanceReport = new FinanceReport(financeReport);
        FinanceReport copy1FinanceReport = new FinanceReport(financeReport);
        assertTrue(copyFinanceReport.equals(copyFinanceReport));
        assertTrue(copyFinanceReport.equals(copy1FinanceReport));
    }

    /*@Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
    }*/
}