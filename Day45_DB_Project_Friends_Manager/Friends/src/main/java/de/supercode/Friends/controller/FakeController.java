package de.supercode.Friends.controller;

import de.supercode.Friends.servicies.FakeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fake")
public class FakeController {

    FakeService fakeService;

    public FakeController(FakeService fakeService) {
        this.fakeService = fakeService;
    }

    @PostMapping
    public void createPersons(){
fakeService.createData();
    }
}
