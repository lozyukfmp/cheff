package by.netcracker.chef.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value = {"/hello", "/"}, method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
