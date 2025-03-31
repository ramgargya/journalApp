package com.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    void testMail() {
        emailService.sendEmail("ramkrsharma2005@gmail.com",
                "Test",
                "This email is test mail");

    }
}
