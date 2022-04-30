package pl.coderslab;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class MultiplyController {

    @GetMapping("/multiply/{size}")
    public String getMultiply(Model model, @RequestParam(defaultValue="10") int size){
        model.addAttribute("size", size);
        return "number";
    }
}
