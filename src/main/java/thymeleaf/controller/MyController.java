package thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myController")
public class MyController {


    @GetMapping(value = "hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping(value = "/show/string")
    public String showSting(Model model){
        model.addAttribute(
                "string", "Welcome to jac");
        return "string";
    }
}
