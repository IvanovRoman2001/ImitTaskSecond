package imit.taskSecond;

import java.util.ArrayList;

public class FinanceReportProcessor {

    public static FinanceReport getReport(FinanceReport financeReport, String begin) {
        if (financeReport == null) throw new IllegalArgumentException();
        ArrayList<Payment> arrayList = new ArrayList<>();
        for (int i = 0; i < financeReport.countPayments(); i++) {
            if (financeReport.getPayment(i).getFullName().startsWith(begin)) {
                arrayList.add(financeReport.getPayment(i));
            }
        }

        return new FinanceReport(
                financeReport.getFullName(),
                financeReport.getDate(),
                arrayList.toArray(new Payment[0])
        );
    }

    public static FinanceReport getPayment(FinanceReport financeReport, double sumMax) {
        if (financeReport == null) throw new IllegalArgumentException();
        else {
            ArrayList<Payment> arrayList = new ArrayList<>();
            for (int i = 0; i < financeReport.countPayments(); i++) {
                if (financeReport.getPayment(i).getSum() < sumMax) {
                    arrayList.add(financeReport.getPayment(i));
                }
            }
            return new FinanceReport(
                    financeReport.getFullName(),
                    financeReport.getDate(),
                    arrayList.toArray(new Payment[0]));
        }
    }
}
