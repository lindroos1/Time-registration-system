package com.learning.Services.Validator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public interface Validator {
    public boolean LeftAfterEntered(LocalDateTime left, LocalDateTime entered);
    public boolean isNotWeekend(DayOfWeek day);
    public boolean sameDay(LocalDateTime left, LocalDateTime entered);

}
