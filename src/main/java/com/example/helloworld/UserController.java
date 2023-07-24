package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final CustomMetrics customMetrics;


    @Autowired
    public UserController(UserRepository userRepository, CustomMetrics customMetrics) {
        this.userRepository = userRepository;
        this.customMetrics = customMetrics;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        customMetrics.incrementUserCreationCounter();
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

