package de.supercode.FirstProject.controller;

import de.supercode.FirstProject.memory.NamesList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class realNameController {
    NamesList namesList;

    public realNameController(NamesList namesList) {
        this.namesList = namesList;
    }

    @PostMapping("{name}")
    public void addYourName(@PathVariable String name) {
        namesList.getNamesList().add(name);
    }

    @GetMapping("{name}")
    public String getHello(@PathVariable String name) {
        return "Hello " + name + ", place to meet you!";
    }
}
