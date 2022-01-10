package com.learning.Services.Time;

import com.learning.Model.Storage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class WeeklyWorkedTime implements TimeWorked {
    @Override
    public Duration compute(Storage storage, String id, LocalDate SearchedDate) {
        Duration duration = Duration.ZERO;
        /*loop tru all days in the selected month*/
        for (var localDate : storage.getEntries(id)) {
            /*if we find the week */
            if (localDate.getDate().getMonth().equals(SearchedDate.getMonth()) &&
                    localDate.getWeek() == SearchedDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR)) {
                duration = duration.plus(localDate.getTimeWorked());
            }
        }
        return duration;
    }
}
