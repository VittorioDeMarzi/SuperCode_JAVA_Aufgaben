package de.supercode.Friends.servicies;

import com.github.javafaker.Faker;
import de.supercode.Friends.entities.Friend;
import de.supercode.Friends.repositories.FriendRepository;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

@Service
public class FakeService {
    Faker faker;
    FriendRepository friendRepository;

    public FakeService(FriendRepository friendRepository) {
        this.faker = new Faker();
        this.friendRepository = friendRepository;
    }

    public Friend friendCreator() {
        Friend fr = new Friend();
        fr.setFirstName(faker.pokemon().name());
        fr.setLastName(faker.dragonBall().character());
        fr.setBirthDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        fr.setPhonNumber(faker.phoneNumber().cellPhone());
        fr.setEmail(faker.internet().emailAddress());
        fr.setOccupation(faker.job().title() + ", " + faker.job().position());
        fr.setIncome(faker.number().numberBetween(500,5500));
        fr.setSelfEmployed(faker.bool().bool());
        fr.setHasBeenCustomerBefore(faker.bool().bool());
        return fr;
    }

    public void createData() {
        for (int i = 0; i < 15; i++) {
            friendRepository.save(friendCreator());
        }
    }

}
