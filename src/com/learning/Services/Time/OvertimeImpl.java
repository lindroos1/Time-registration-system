package com.learning.Services.Time;

import com.learning.Model.Storage;

import java.time.Duration;
import java.time.LocalDate;

/* we brake the rules by not returning a duration, but this way it is easier
*  to return two arguments - the id and the time*/
public class OvertimeImpl implements Overtime {
    private final MonthlyWorkedTime monthlyWorkedTime = new MonthlyWorkedTime();
    private Duration duration = Duration.ZERO;
    private String key = "";

    @Override
    public String compute(Storage storage, LocalDate date) {
        //TODO: catch the case when two people overachieved
        for (var entry : storage.getStorage().entrySet()) {
            var localTime = monthlyWorkedTime.compute(storage, entry.getKey(), date);
            if (localTime.compareTo(duration) >= 1) {
                duration = localTime;
                key = entry.getKey();
            }
        }
        int maximumWorkingHours = 160;
        if (duration.toHours() > maximumWorkingHours) {
            return key + " has worked " + duration.toHours() + " hours and " +
                    duration.minusHours(duration.toHours()).toMinutes() + " minutes. He did it!";
        }
        return "there isn't any overachiever this month";
    }
}
