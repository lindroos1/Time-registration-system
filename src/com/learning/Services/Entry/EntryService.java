package com.learning.Services.Entry;

import com.learning.Model.Entry;
import com.learning.Model.Storage;

import java.time.LocalDateTime;

public class EntryService {
    private final Entry entry;
    private final Storage storage;

    public EntryService(Entry entry, Storage storage) {
        this.entry = entry;
        this.storage = storage;
    }

    public void updateEntry(LocalDateTime entered, LocalDateTime left) {
        entry.setEntered(entered);
        entry.setLeft(left);
        entry.computeDuration();
        storage.put(entry.getId(), entry);
    }
}
