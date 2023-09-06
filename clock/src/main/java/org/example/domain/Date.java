package org.example.domain;

public class Date {
    private final String day;
    private final String month;
    private final int year;

    public Date(String day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
