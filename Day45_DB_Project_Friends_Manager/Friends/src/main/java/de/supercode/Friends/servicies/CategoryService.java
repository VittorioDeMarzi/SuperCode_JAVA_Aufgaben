package de.supercode.Friends.servicies;

import com.github.javafaker.Cat;
import de.supercode.Friends.entities.Category;
import de.supercode.Friends.entities.Friend;
import de.supercode.Friends.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    FriendService friendService;

    public CategoryService(CategoryRepository categoryRepository, FriendService friendService) {
        this.categoryRepository = categoryRepository;
        this.friendService = friendService;
    }

    // create
    public Category saveNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    public void addCategoryToFriend(long friendId, String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName).get();
        Friend friend = friendService.getFriendById(friendId).get();
        category.getFriends().add(friend);
        friend.setCategory(category);
        friendService.update(friend);
        categoryRepository.save(category);
    }

}
