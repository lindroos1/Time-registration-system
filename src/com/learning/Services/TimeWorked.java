package com.learning.Services;
import com.learning.Model.Storage;

import java.time.Duration;
import java.time.LocalDate;

public interface TimeWorked {
    public Duration compute(Storage storage, String id, LocalDate date);
}
