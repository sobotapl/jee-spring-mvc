package pl.coderslab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class Task4Controller {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/form")
    public String hello() {
        return "form";
    }



    @PostMapping("/form")
    @ResponseBody
    public String getParamName(@RequestParam ("paramName") String paramName, @RequestParam ("paramDate")String paramDate) {
        LocalDate format = LocalDate.parse(paramDate, DATE_TIME_FORMATTER);
        return paramName + " " + format;
    }

    @GetMapping("/helloView")
    public String helloView(Model model){
        LocalTime actualTime = LocalTime.now();

        if(actualTime.isAfter(LocalTime.of(8,0)) && actualTime.isBefore(LocalTime.of(20,0))){
            model.addAttribute("color","black");
            model.addAttribute("backgroundColor", "white");

        } else {
            model.addAttribute("color","white");
            model.addAttribute("backgroundColor", "black");

        }
        return "home";
    }

}
