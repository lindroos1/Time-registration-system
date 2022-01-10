package tests;
import com.learning.Model.Entry;
import com.learning.Model.Storage;
import com.learning.Services.Time.DailyWorkedTime;
import com.learning.Services.Time.MonthlyWorkedTime;
import com.learning.Services.Time.OvertimeImpl;
import com.learning.Services.Time.WeeklyWorkedTime;
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
    OvertimeImpl overtime = new OvertimeImpl();

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
            storage.put(id, entry);
        }

        String id2 = "georgi_id";
        for(int i = 3; i < 30; i++){
            Entry entry = new Entry();
            entry.setId(id);
            entry.setEntered(LocalDateTime.of(2022, 1, i, 10, 20));
            entry.setLeft(LocalDateTime.of(2022, 1, i, 20, 10));
            entry.computeDuration();
            storage.put(id2, entry);
        }
    }

    @Test
    void WorkedHoursDay(){
        //pas the YY/MM/DD, aka LocalDate obj
        LocalDate date = LocalDate.of(2022, 1, 5);
        Assertions.assertNotNull(dailyWorkedTime.compute(storage, "ivan_id", date));
    }

    @Test
    void WorkedHoursWeek(){
        LocalDate date = LocalDate.of(2022, 1, 3);

        //5 days from 3th to 8th, every one of them with working time of 5H 50M = 29:10 hours total
        Assertions.assertEquals("PT29H10M", weeklyWorkedTime.compute(storage, "ivan_id", date)
                .toString());
    }

    @Test
    void WorkedHoursMonth(){
        LocalDate date = LocalDate.of(2022, 1, 3);
        Assertions.assertEquals("PT40H50M", monthlyWorkedTime.compute(storage, "ivan_id", date)
                .toString());
    }


    @Test
    void OverAchieving(){
        Assertions.assertTrue((overtime.compute(storage, LocalDate.of(2022, 1, 3))
                .contains("265 hours and 30 minutes")));
    }
}
