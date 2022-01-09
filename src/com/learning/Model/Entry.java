package com.learning.Model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Entry {
    private String id;
    private LocalDateTime entered;
    private LocalDateTime left;
    private Duration objectHours;

    public int getWeek() {
        return week;
    }

    private int week;

    public void computeDuration() {
        Duration duration = Duration.between(entered, left);
        //get hours
        long hours = duration.toHours();
        //subtract hours from the whole to obtain minutes
        duration = duration.minusHours(hours);

        System.out.println("You have worked " + hours +
                " hours and " + duration.toMinutes() + " minutes");
        objectHours = Duration.ofHours(hours).plusMinutes(duration.toMinutes());
        System.out.println("Duration " + objectHours);
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
        return objectHours;
    }

    public LocalDate getDate() {
        return LocalDate.of(entered.getYear(), entered.getMonth(), entered.getDayOfMonth());
    }
}
