package de.supercode.Friends.repositories;

import de.supercode.Friends.entities.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByIncomeGreaterThan(long income);

    List<Friend> findByIsSelfEmployed(Boolean isSelfEmployed);

    List<Friend> findByBirthDateAfter(LocalDate birthday);

    Optional<List<Friend>> findByIncomeGreaterThanAndIsSelfEmployed(long income, Boolean isSelfEmployed);


}
