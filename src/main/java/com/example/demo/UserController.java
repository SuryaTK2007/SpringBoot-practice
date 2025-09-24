package com.example.demo;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    public UserController(UserRepository userRepository, ItemRepository itemRepository){
        this.userRepository=userRepository;
        this.itemRepository=itemRepository;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PostMapping("/users/{userId}/items")
    public Item addItemToUser(@PathVariable Long userId, @RequestBody Item item){
        User user=userRepository.findById(userId)
        .orElseThrow(()->new RuntimeException("User not found with id: "+userId));
        item.setUser(user);
        return itemRepository.save(item);
    }   
    @GetMapping("/users/{userId}/items")
    public List<Item> getItemsForUser(@PathVariable Long userId){
        User user = userRepository.findById(userId)
        .orElseThrow(()->new RuntimeException("User not found with id: "+userId));
        return user.getItems();
    }
}
