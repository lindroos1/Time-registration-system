package com.learning.Services;

import com.learning.Model.Storage;

import java.time.Duration;
import java.time.LocalDate;

public class MonthlyWorkedTime implements TimeWorked {
    @Override
    public Duration compute(Storage storage, String id, LocalDate SearchedDate) {
        Duration duration = Duration.ZERO;
        /*loop tru all days in all entities */
        for (var localDate : storage.getEntries(id)) {
            /*if we find the month */
            if (localDate.getDate().getMonth().equals(SearchedDate.getMonth())) {
                duration = duration.plus(localDate.getTimeWorked());
            }
        }
        return duration;
    }
}
