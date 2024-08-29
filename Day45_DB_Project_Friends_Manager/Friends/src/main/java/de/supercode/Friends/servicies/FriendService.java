package de.supercode.Friends.servicies;

import de.supercode.Friends.entities.Friend;
import de.supercode.Friends.repositories.FriendRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
    FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    // post
    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    // get
    public List<Friend> getAllFriends() {
        List<Friend> friends = new ArrayList<>();
        friendRepository.findAll().forEach(friends::add);
        return friends;
    }

    public Optional<Friend> getFriendById(long id) {
        return friendRepository.findById(id);
    }

    public List<Friend> findByIncomeGreaterThan(long id) {
        return friendRepository.findByIncomeGreaterThan(id);
    }

    public List<Friend> findByIsSelfEmployed(Boolean isSelfEmployed) {
        return friendRepository.findByIsSelfEmployed(isSelfEmployed);
    }

    public List<Friend> findByBirthdayGreaterThan (LocalDate birthday) {
        return friendRepository.findByBirthDateAfter(birthday);
    }

    // delete
    public void deleteById(long id) {
        friendRepository.deleteById(id);
    }

}
