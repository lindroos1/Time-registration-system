package com.learning.Services;

import com.learning.Model.Storage;

import java.time.Duration;
import java.time.LocalDate;

public class DailyWorkedTime implements TimeWorked {

    @Override
    public Duration compute(Storage storage, String id, LocalDate SearchedDate) {
        for (var localDate : storage.getEntries(id)) {
            if (localDate.getDate().isEqual(SearchedDate)) {
                return localDate.getTimeWorked();
            }
        }
        return null;
    }

}
