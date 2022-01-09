package com.learning;

import com.learning.Helpres.Options;
import com.learning.Model.Entry;
import com.learning.Model.Storage;
import com.learning.Services.*;
import com.learning.View.View;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        /* inits the necessary objects */
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage();
        DailyWorkedTime dailyWorkedTime = new DailyWorkedTime();
        WeeklyWorkedTime weeklyWorkedTime = new WeeklyWorkedTime();
        MonthlyWorkedTime monthlyWorkedTime = new MonthlyWorkedTime();
        Options options = new Options();
        View view = new View();
        ValidatorImpl validator = new ValidatorImpl();


        /* prints the options so the user knows how to use the app */
        options.get();
        /* takes an option*/
        String option = sc.next();

        /* main app loop - accepts input until exit is typed */
        while (!option.equalsIgnoreCase("exit")) {
            /* accepts entry form the user, creates entry object and assigns that id */
            view.id();
            String id = sc.next();
            Entry entry = new Entry();
            entry.setId(id);
            /* if the user wants to add entry*/
            if (option.equalsIgnoreCase("entry")) {
                /* tells the user to input entry and parses it to LocalDateTime */
                view.came();
                LocalDateTime entered = LocalDateTime.parse(sc.next());
                view.left();
                LocalDateTime left = LocalDateTime.parse(sc.next());

                /* checks if end time is past entered time */
                if (validator.LeftAfterEntered(left, entered)) {
                    /* checks if they are on the same day */
                    if (validator.sameDay(left, entered)) {
                        /* checks for weekend can be done */
                        if (validator.isNotWeekend(left.getDayOfWeek())) {
                            EntryService entryService = new EntryService(entry, storage);
                            entryService.updateEntry(entered, left);
                        } else
                            view.workOnWeekend();
                    } else
                        view.differentDays();
                } else
                    view.leaveBeforeCame();
            }
            if (option.equalsIgnoreCase("dailyWorked")) {
                view.enterDay();
                LocalDate date = LocalDate.parse(sc.next());
                if (validator.isNotWeekend(date.getDayOfWeek())) {
                    view.timeWorked(dailyWorkedTime.compute(storage, entry.getId(),
                            date));
                } else
                    throw new RuntimeException("you should pass a weekday");
            }
            if (option.equalsIgnoreCase("weeklyWorked")) {
                view.enterWeek();
                LocalDate date = LocalDate.parse(sc.next());
                view.timeWorked(weeklyWorkedTime.compute(storage, entry.getId(),
                        date));
            }
            if (option.equalsIgnoreCase("monthlyWorked")) {
                view.enterMonth();
                view.timeWorked(monthlyWorkedTime.compute(storage, entry.getId(),
                        LocalDate.parse(sc.next())));

            }
            options.get();
            option = sc.next();
        }
    }
}
