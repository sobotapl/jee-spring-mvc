package pl.coderslab;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    Random rd = new Random();


    @GetMapping(value ="/random/{min}/{max}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showRandom(@PathVariable int max, @PathVariable int min){
        int randomNumber = rd.nextInt(max - min)+min;
        return "Podana wartosc max: " + max + "min: " +min+ ". Wylosowano liczbe: " +randomNumber;
    }

//    @GetMapping(value ="/random/{max}", produces = "text/plain;charset=UTF-8")
//    @ResponseBody
//    public String showRandom(@PathVariable int max){
//        int randomNumber = rd.nextInt(max)+1;
//        return "Podana wartosc max: " + max + ". Wylosowano liczbe: " +randomNumber;
//    }



    @GetMapping(value = "/show-random", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getNumber(){
        int num = rd.nextInt(100)+1;
        return "Wylosowana Liczba: "+num;
    }

}
