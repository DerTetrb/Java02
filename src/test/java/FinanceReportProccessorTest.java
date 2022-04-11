import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class FinanceReportProccessorTest {


    FinanceReport financeReport = new FinanceReport("Толик", new GregorianCalendar(2021, Calendar.FEBRUARY, 10),
            new Payment("Petr", 100.2, new GregorianCalendar(2010, Calendar.FEBRUARY, 20)),
            new Payment("Vadim", 99.99, new GregorianCalendar(2019, Calendar.MARCH, 2)),
            new Payment("Petr", 1.2, new GregorianCalendar(2020, Calendar.JANUARY, 1)));

    @Test
    public void testFilterByPrefix() {
        FinanceReport copy = new FinanceReport(financeReport);
        FinanceReport result1 = FinanceReportProccessor.getReport(financeReport, "Pe");
        System.out.println(result1.toString());
        assertEquals(result1.getArr().length, 2);
        FinanceReport result2 = FinanceReportProccessor.getReport(financeReport, "V");
        System.out.println(result2.toString());
        assertEquals(result2.getArr().length, 1);
    }

    @Test
    public void testFilterByLimit() {
        FinanceReport result = FinanceReportProccessor.getPayment(financeReport, 10);
        System.out.println(result.toString());
        assertEquals(result.getArr().length, 1);

    }
}