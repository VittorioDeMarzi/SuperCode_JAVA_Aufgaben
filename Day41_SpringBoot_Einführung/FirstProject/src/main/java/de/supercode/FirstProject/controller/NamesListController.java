package de.supercode.FirstProject.controller;

import de.supercode.FirstProject.memory.NamesList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class NamesListController {
    NamesList namesList;

    public NamesListController(NamesList namesList) {
        this.namesList = namesList;
    }

    @GetMapping("name")
    public ArrayList<String> giveMeNamesList() {
        return namesList.getNamesList();
    }

    @PostMapping("name")
    public void addName() {
        namesList.getNamesList().add("Name");
    }

}
