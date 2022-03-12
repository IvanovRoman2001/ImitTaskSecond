package imit.taskSecond;

import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest {
    FinanceReport financeReport = new FinanceReport("Sergey", new Date(1, 12, 2001),
            new Payment("Pyaterochka", new Date(19, 8, 2003), 345),
            new Payment("Magnit", new Date(20, 3, 2020), 34.56),
            new Payment("Perekrestok", new Date(30,5, 2002), 3.45));

    @Test
    public void testFilterByPrefix() {
        FinanceReport result1 = FinanceReportProcessor.getReport(financeReport, "P");
        assertEquals(2, result1.getPayments().length);
        FinanceReport result2 = FinanceReportProcessor.getReport(financeReport, "xxxxx");
        assertEquals(0, result2.getPayments().length);
    }

    @Test
    public void testFilterByLimit() {
        FinanceReport result = FinanceReportProcessor.getPayment(financeReport, 10);
        assertEquals(1, result.getPayments().length);
    }
}


/*
**null, null
**null, ""
**null, "asd"
FR, null
FR, ""   (expected same FR or exception)
*FR, "A"  (expected empty fin rep)
*FR, "B"  (expected not empty fin rep)*/