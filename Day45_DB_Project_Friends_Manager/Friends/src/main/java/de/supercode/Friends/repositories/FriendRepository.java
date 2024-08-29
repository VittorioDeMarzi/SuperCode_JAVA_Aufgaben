package de.supercode.Friends.repositories;

import de.supercode.Friends.entities.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByIncomeGreaterThan(long income);

    List<Friend> findByIsSelfEmployed(Boolean isSelfEmployed);

    List<Friend> findByBirthDateAfter(LocalDate birthday);
}
