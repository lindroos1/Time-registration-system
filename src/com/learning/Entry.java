package com.learning;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Entry {
    private String id;
    private LocalDateTime entered;
    private LocalDateTime left;
    private Duration hourss;

    public int getWeek() {
        return week;
    }

    private int week;

    public void computeDuration(){
        Duration duration = Duration.between(entered, left);
        //get hours
        long hours = duration.toHours();
        //subtract hours from the whole to obtain minutes
        duration = duration.minusHours(hours);

        System.out.println("You have worked " +  hours +
                " hours and "+ duration.toMinutes() + " minutes");
        hourss = Duration.ofHours(hours).plusMinutes(duration.toMinutes());
        System.out.println("Duration " + hourss);
        week = entered.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntered(LocalDateTime entered) {
        this.entered = entered;
    }


    public void setLeft(LocalDateTime left) {
        this.left = left;
    }

    public Duration getTimeWorked() {
        return hourss;
    }

    public LocalDate getDate(){
        return LocalDate.of(entered.getYear(), entered.getMonth(), entered.getDayOfMonth());
    }
}
