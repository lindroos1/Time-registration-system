package com.learning;

import java.time.LocalDate;

public class DailyWorkedTime implements TimeWorked {

    @Override
    public Entry compute(Storage storage, String id, LocalDate SearchedDate ) {
           for(var localDate: storage.getEntries(id)){
               if(localDate.getDate().isEqual(SearchedDate)){
                   return localDate;
               }
           }
           return  null;
    }
}
