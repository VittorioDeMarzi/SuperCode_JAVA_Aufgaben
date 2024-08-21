package de.supercode.FirstProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingsController {

    @GetMapping("/api/hello")
    public String sayHello () {
        return "Hello, my name is Vittorio";
    }

    @GetMapping("/api/by")
    public String sayBay () {
        return "Bye bye, I'll see you tomorrow";
    }

}
