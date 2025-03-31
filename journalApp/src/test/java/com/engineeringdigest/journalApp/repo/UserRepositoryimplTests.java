package com.engineeringdigest.journalApp.repo;


import com.engineeringdigest.journalApp.repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryimplTests {

    @Autowired
    private UserRepositoryImpl userRepositoryimpl;

    @Test
    public void testUser() {
        userRepositoryimpl.getUserForSA();
    }
}
