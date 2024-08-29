package de.supercode.Friends.controller;

import de.supercode.Friends.entities.Category;
import de.supercode.Friends.servicies.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // post new category
    @PostMapping
    public ResponseEntity<Category> saneNewCategory(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveNewCategory(category));
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.FOUND);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{friendId}/{categoryName}")
    public void addFriendToCategory(@PathVariable long friendId, @PathVariable String categoryName){
        this.categoryService.addCategoryToFriend(friendId, categoryName);
    }
}
