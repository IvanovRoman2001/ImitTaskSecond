package imit.taskSecond;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (Date.isCorrectDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else throw new IllegalArgumentException();
    }

    public Date(Date date) {
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(Date.isCorrectDate(day, month, year)) this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(Date.isCorrectDate(day, month, year)) this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(Date.isCorrectDate(day, month, year)) this.year = year;
    }

    //equal
    //toString()
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) return true;
        return false;
    }
    public static  boolean isCorrectDate(int day, int month, int year) {
        int [] days= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int [] daysLeapYear= {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month >= 1 && month <= 12) {
            if (!isLeapYear(year)) {
                if (day == days[month - 1]) return true;
            }
            else return false;
            if (isLeapYear(year)) {
                if (day == daysLeapYear[month - 1]) return true;
            }
            else return false;
        }
        return false;
    }
}
