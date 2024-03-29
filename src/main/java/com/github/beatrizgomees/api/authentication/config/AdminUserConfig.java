package com.github.beatrizgomees.api.authentication.config;

import com.github.beatrizgomees.api.authentication.User.User;
import com.github.beatrizgomees.api.authentication.User.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var user = userRepository.findByEmail("useremail@gmail.com");

        user.ifPresentOrElse(
                userExist -> {

                    System.out.println("User existe");
                },
                () -> {
                    var createUser = new User();
                    createUser.setName("User 01");
                    createUser.setEmail("useremail@gmail.com");
                    createUser.setUsername("user01");
                    createUser.setPassword(passwordEncoder.encode("12345"));
                    userRepository.save(createUser);
                }
        );

    }
}
