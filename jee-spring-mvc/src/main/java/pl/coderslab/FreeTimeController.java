package pl.coderslab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Controller
public class FreeTimeController {

    private static final LocalTime START_WORK = LocalTime.of(9,0);
    private static final LocalTime END_WORK = LocalTime.of(17,0);

    @GetMapping("/checkTime")
    @ResponseBody
    public String checkTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (DayOfWeek.SATURDAY.equals(localDateTime.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(localDateTime.getDayOfWeek())) {
            return "Wolne";
        } else if (localDateTime.toLocalTime().isAfter(START_WORK) && localDateTime.toLocalTime().isBefore(END_WORK)) {
            return "Pracuje, nie dzwon";
        } else {
            return "Po pracy";
        }
    }

}