package com.learning.Services;

import com.learning.Model.Storage;

import java.time.LocalDate;

public interface Overtime {
    public String compute(Storage storage, LocalDate SearchedDate);
}
