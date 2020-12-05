package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CovidRecord {
    private String date;
    private String day;
    private Integer peopleTestedTotal;
    private Integer peoplePositiveTotal;


    public CovidRecord(String date, String day, String peopleTestedTotal, String peoplePositiveTotal) {
        super();
        this.date = date;
        this.day = day;
        this.peopleTestedTotal = Integer.parseInt(peopleTestedTotal);
        this.peoplePositiveTotal = Integer.parseInt(peoplePositiveTotal);
    }

    public String getDate() throws ParseException {
        String datetemp = (date.substring(0,10));
        String Year = datetemp.substring(0,4);
        String Month = datetemp.substring(5,7);
        String Day = datetemp.substring(8,10);
        String output = Month.concat("/").concat(Day).concat("/").concat(Year);
        System.out.println(output);
        return output;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getPeopleTestedTotal() {
        return peopleTestedTotal;
    }

    public void setPeopleTestedTotal(Integer peopleTestedTotal) {
        this.peopleTestedTotal = peopleTestedTotal;
    }

    public Integer getPeoplePositiveTotal() {
        return peoplePositiveTotal;
    }

    public void setPeoplePositiveTotal(Integer peoplePositiveTotal) {
        this.peoplePositiveTotal = peoplePositiveTotal;
    }

}
