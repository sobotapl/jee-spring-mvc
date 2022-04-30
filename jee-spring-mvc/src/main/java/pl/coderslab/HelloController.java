package pl.coderslab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }


    @GetMapping(value ="/hello/{firstName}/{lastName}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandom(@PathVariable String firstName, @PathVariable String lastName){
        return firstName +" "+ lastName;
    }

}
