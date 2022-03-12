package imit.taskSecond;

public class PaymentTest {
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testSumInvalid() {
        Payment payment = new Payment("name", new Date(1, 12, 2001), -42.0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testNameInvalid() {
        Payment payment = new Payment(null, new Date(27, 5, 2002), 100.0);
    }
}
