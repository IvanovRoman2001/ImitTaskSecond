package imit.taskSecond;

import imit.taskSecond.FinanceReport;
import imit.taskSecond.Payment;

import static org.junit.Assert.*;

public class FinanceReportTest {
    FinanceReport financeReport = new FinanceReport("Sergey", new Date(1, 12, 2001),
            new Payment("Pyaterochka", new Date(19, 8, 2003), 345),
            new Payment("Magnit", new Date(3, 3, 1978), 34.56),
            new Payment("Perekrestok", new Date(23, 7, 1972), 3.45));

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidIndex() {
        financeReport.getPayment(financeReport.getPayments().length + 100);
    }

    @org.junit.Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(financeReport);
        copy.setPayment(new Payment("name", new Date(16, 5, 1999), 34.67), 0);
        assertNotEquals(copy.getPayment(0), financeReport.getPayment(0));
    }
}