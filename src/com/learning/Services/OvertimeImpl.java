package com.learning.Services;

import com.learning.Model.Storage;

import java.time.Duration;
import java.time.LocalDate;

public class OvertimeImpl implements Overtime {
    private final MonthlyWorkedTime monthlyWorkedTime = new MonthlyWorkedTime();
    private Duration duration = Duration.ZERO;
    private String key = "";

    @Override
    public String compute(Storage storage, LocalDate date) {
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
