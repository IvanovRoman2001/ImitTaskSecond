package imit.taskSecond;

import java.util.Objects;

public class Payment {
    private String fullName;
    private Date date;
    private double sum;

    public Payment(String fullName, Date date, double sum) {
        if (fullName == null) throw new IllegalArgumentException();
        if (sum <= 0) throw new IllegalArgumentException("Negative sum!");
        this.fullName = fullName;
        this.date = date;
        this.sum = sum;
    }

    public Payment(Payment payment) {
        this.fullName = payment.getFullName();
        this.date = payment.getDate();
        this.sum = payment.getSum();
    }

    public Date getDate() {
        return date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return this.date.getDay();
    }

    public void setDay(int day) {
        date.setDay(day);
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public void setMonth(int month) {
        date.setMonth(month);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public void setYear(int year) {
        date.setYear(year);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        if (sum <= 0) throw new IllegalArgumentException("Negative sum!");
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return date.getDay() == payment.getDay() &&
                date.getMonth() == payment.getMonth() &&
                date.getYear() == payment.getYear() &&
                sum == payment.sum &&
                Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, date.getDay(), date.getMonth(), date.getYear(), sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "fullName='" + fullName + '\'' +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
