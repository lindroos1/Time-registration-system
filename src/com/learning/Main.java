package com.learning;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Time time = new Time();
        Entry entry = new Entry();
        Storage storage = new Storage();

        System.out.println("Enter your id:");
        entry.setId(sc.next());

        System.out.println("When did you come?");
        /* takes time from the CLI*/
        LocalTime came = time.takeTime();

        LocalDateTime entered = LocalDateTime.now();
        entered = LocalDateTime.of(entered.getYear(), entered.getMonth(), 7,
                came.getHour(), came.getMinute());
        System.out.println("you came at: " +  entered.toString());


        System.out.println("When did you leave");
        LocalTime Timeleft = time.takeTime();
        LocalDateTime left = LocalDateTime.of(entered.getYear(), entered.getMonth(),  7,
                 Timeleft.getHour(), Timeleft.getMinute());
        System.out.println(left.getDayOfWeek().getDisplayName(TextStyle.FULL , Locale.UK));

        DayOfWeek day = left.getDayOfWeek();
        /*
            if he left after he arrived, and it wasn't sunday nor saturday

            because the system uses LocalDateTime.now() to determine what day/year/month is,
            it is impossible to enter different days for badged in/out

            for instance if you enter say 10:00 you came, if you enter 00:30 for the badged out time
            it will assume you came at 10:00 in the morning and left before you arrive, so invalid
            input
         */

        if(left.isAfter(entered)){
            if(!(day.equals(DayOfWeek.SUNDAY) || day.equals(DayOfWeek.SATURDAY))){
                entry.setEntered(entered);
                entry.setLeft(left);
                entry.computeDuration();
                storage.put(entry.getId(), entry);
            }
            else
                System.out.println("Invalid input: You are supposed to chill" +
                        " on the weekend, not work");
        }
        else
            System.out.println("Invalid input: it is not possible to leave before you came");
    }
}
