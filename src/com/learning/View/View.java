package com.learning.View;

import java.time.Duration;

public class View {
    public void id() {
        System.out.println("Enter your id:");
    }

    public void came() {
        System.out.println("When did you come?");
    }

    public void left() {
        System.out.println("When did you leave");
    }

    public void workOnWeekend() {
        System.out.println("Invalid input: You are supposed to chill" +
                " on the weekend, not work");
    }

    public void leaveBeforeCame() {
        System.out.println("Invalid input: it is not possible to leave before you came");
    }

    public void timeWorked(Duration timeWorked) {
        System.out.println(timeWorked);
    }

    public void enterDay() {
        System.out.println("Enter the day in format YY:MM:DD");
    }

    public void enterWeek() {
        System.out.println("Enter a day (monday) in format YY:MM:DD");
    }

    public void enterMonth() {
        System.out.println("Enter the month in format YY:MM:DD");
    }
    public void overAchieverRender(String name){
        System.out.println(name);
    }

    public void differentDays() {
        System.out.println("Invalid input: You come and leave on a different days!");
    }
}
