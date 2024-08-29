package de.supercode.Friends.controller;

import de.supercode.Friends.entities.Friend;
import de.supercode.Friends.servicies.FriendService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/friends")
public class friendController {
    FriendService friendService;

    public friendController(FriendService friendService) {
        this.friendService = friendService;
    }

    // post
    @PostMapping("")
    public ResponseEntity<Friend> saveFriend(@RequestBody Friend friend) {
        return ResponseEntity.status(HttpStatus.CREATED).body(friendService.saveFriend(friend));
    }

    // get
    @GetMapping("")
    public ResponseEntity<List<Friend>> getAllFriends() {
        try {
            return new ResponseEntity<>(friendService.getAllFriends(), HttpStatus.FOUND);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Friend> getFriendById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(friendService.getFriendById(id).get(), HttpStatus.FOUND);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/incomeGreaterThan/{income}")
    public List<Friend> findByIncomeGreaterThan(@PathVariable long income) {
        return friendService.findByIncomeGreaterThan(income);
    }

    @GetMapping("/friend")
    public List<Friend> findByIsSelfEmployed(@RequestParam Boolean isSelfEmployed) {
        return friendService.findByIsSelfEmployed(isSelfEmployed);
    }

    @GetMapping("/friendBirthDate")
    public ResponseEntity<List<Friend>> findByBirthdayGreaterThan(@RequestParam String birthday) {
        try {
            return new ResponseEntity<>(friendService.findByBirthdayGreaterThan(LocalDate.parse(birthday)), HttpStatus.FOUND);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // delete
    public ResponseEntity<Optional<Friend>> deleteById(@PathVariable long id) {
        Optional<Friend> friend = friendService.getFriendById(id);
        if (friend.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(friend);
        else {
            friendService.deleteById(id);
            return ResponseEntity.status(HttpStatus.GONE).body(friend);
        }
    }

    // put
//    public ResponseEntity<Friend>
}
