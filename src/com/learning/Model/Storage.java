package com.learning.Model;

import java.util.ArrayList;
import java.util.HashMap;

/* this class represents a Nosql DB*/
public class Storage {

    private final HashMap<String, ArrayList<Entry>> storage = new HashMap<>();

    public HashMap<String, ArrayList<Entry>> getStorage() {
        return storage;
    }

    public void put(String key, Entry entry) {
        if (!storage.containsKey(key)) {
            storage.put(key, new ArrayList<>());
        }
        storage.get(key).add(entry);
    }

    public ArrayList<Entry> getEntries(String key) {
        if (!storage.containsKey(key)) {
            return null;
        }
        return storage.get(key);
    }

}
