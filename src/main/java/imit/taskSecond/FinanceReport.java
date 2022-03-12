package imit.taskSecond;

import java.util.Arrays;

public class FinanceReport {
    private Payment [] payments;
    private String fullName;
    private Date date;

    public FinanceReport(String fullName, Date date, Payment... payments) {
        this.payments = payments.clone();
        this.fullName = fullName;
        this.date = new Date(date);
    }

    private void assertPaymentsNotNull() {
        if (payments == null) {
            throw new IllegalArgumentException();
        }
    }

    public Payment[] getPayments() {
        return payments;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDate() {
        return date;
    }

    public int getDay() {
        return date.getDay();
    }

    public int getMonth() {
        return date.getMonth();
    }

    public int getYear() {
        return date.getYear();
    }

    public FinanceReport(FinanceReport financeReport) {
        this.payments = financeReport.getPayments().clone();
        this.fullName = financeReport.getFullName();
        this.date = financeReport.getDate();
    }

    public int countPayments() {
        return payments.length;
    }

    public Payment getPayment(int index) {
        assertPaymentsNotNull();
        if (index < 0 || this.payments.length <= index) throw new IndexOutOfBoundsException();
        return payments[index];
    }

    public void setPayment(Payment payment, int index) {
        assertPaymentsNotNull();
        if (index < 0 || this.payments.length <= index) throw new IndexOutOfBoundsException();
        payments[index] = new Payment(payment);
    }

    @Override
    public String toString() {
        return String.format("[Автор %s, дата: %d.%d.%d, Платежи: %n%s]", fullName, date.getDay(), date.getMonth(),
                date.getYear(), Arrays.toString(payments)
        );
    }
}
