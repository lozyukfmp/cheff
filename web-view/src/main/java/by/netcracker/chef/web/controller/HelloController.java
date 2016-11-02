package by.netcracker.chef.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    @RequestMapping(value = {"/hello", "/"}, method = RequestMethod.GET)
    public String hello() {
        logger.trace("REQUEST FOR WELCOME PAGE");
        return "hello";
    }

}
