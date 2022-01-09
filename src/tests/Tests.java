package tests;
import com.learning.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tests {

    Storage storage = new Storage();
    DailyWorkedTime dailyWorkedTime = new DailyWorkedTime();
    WeeklyWorkedTime weeklyWorkedTime = new WeeklyWorkedTime();
    MonthlyWorkedTime monthlyWorkedTime = new MonthlyWorkedTime();
    @BeforeEach
    void setUp(){
        //fill with info to test
        String id = "ivan_id";
        for(int i = 3; i < 10; i++){
            Entry entry = new Entry();
            entry.setId(id);
            entry.setEntered(LocalDateTime.of(2022, 1, i, 10, 20));
            entry.setLeft(LocalDateTime.of(2022, 1, i, 16, 10));
            entry.computeDuration();
            storage.put("ivan_d", entry);
        }

    }

    @Test
    void WorkedHoursDay(){
        //pas the YY/MM/DD, aka LocalDate obj
        LocalDate date = LocalDate.of(2022, 1, 5);
        Assertions.assertNotNull(dailyWorkedTime.compute(storage, "ivan_d", date));
        System.out.println(storage.getEntries("ivan_d").get(0).getWeek());
    }

    @Test
    void WorkedHoursWeek(){
        LocalDate date = LocalDate.of(2022, 1, 3);

        //5 days from 3th to 8th, every one of them with working time of 5H 50M = 29:10 hours total
        Assertions.assertEquals("PT29H10M", weeklyWorkedTime.compute(storage, "ivan_d", date)
                .toString());
    }

    @Test
    void WorkedHoursMonth(){
        LocalDate date = LocalDate.of(2022, 1, 3);
        Assertions.assertEquals("PT40H50M", monthlyWorkedTime.compute(storage, "ivan_d", date)
                .toString());
    }
}
