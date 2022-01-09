package com.learning;
import java.time.Duration;
import java.time.LocalDate;

public interface TimeWorked {
    public Duration compute(Storage storage, String id, LocalDate date);
}
