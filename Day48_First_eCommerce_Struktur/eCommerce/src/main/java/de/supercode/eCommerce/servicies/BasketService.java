package de.supercode.eCommerce.servicies;

import de.supercode.eCommerce.entities.Basket;
import de.supercode.eCommerce.repositories.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    // save new basket
    public void saveNewBasket(Basket basket) {
        basketRepository.save(basket);
    }
}
