package com.app.rightfix;

import com.app.rightfix.entity.User;
import com.app.rightfix.enums.Gender;
import com.app.rightfix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class RightfixApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RightfixApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            createUser();
        };
    }

    private void createUser() {
        // create the user
        User tempUser1 = new User(
                "Le Quang Nhat",
                Gender.MALE,
                LocalDate.parse("2002-01-26"),
                "coderga",
                "quangnhat2601@gmail.com",
                passwordEncoder.encode("12345"));
        System.out.println("Saving User with userId: " + tempUser1.getId());
        userRepository.save(tempUser1);
        System.out.println("DONE");
    }
}
