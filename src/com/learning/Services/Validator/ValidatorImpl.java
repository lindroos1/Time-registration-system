package com.learning.Services.Validator;

import com.learning.Services.Validator.Validator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ValidatorImpl implements Validator {
    @Override
    public boolean LeftAfterEntered(LocalDateTime left, LocalDateTime entered) {
        return left.isAfter(entered);
    }

    @Override
    public boolean isNotWeekend(DayOfWeek day) {
        return !(day.equals(DayOfWeek.SUNDAY) || day.equals(DayOfWeek.SATURDAY));
    }

    @Override
    public boolean sameDay(LocalDateTime left, LocalDateTime entered) {
        return left.getDayOfWeek().equals(entered.getDayOfWeek());
    }
}
