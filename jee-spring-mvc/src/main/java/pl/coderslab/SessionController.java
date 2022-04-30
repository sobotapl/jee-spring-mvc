package pl.coderslab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@SessionAttributes("loginStart")
public class SessionController {

    @GetMapping("/loginStart")
    @ResponseBody
    public String loginStart(Model model, HttpSession httpSession){
        LocalDateTime loginStartDate = (LocalDateTime) httpSession.getAttribute("loginStart");
        if(loginStartDate == null){
            model.addAttribute("loginStart", LocalDateTime.now());
            return "ustawiono wartosc";
        }
        return loginStartDate.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
