package com.example.helloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testIntegration() {
        User user = new User();
        user.setName("John");
        user.setAge(30);

        userRepository.save(user);

        List<User> users = userRepository.findAll();
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals("John", users.get(0).getName());
    }
}

