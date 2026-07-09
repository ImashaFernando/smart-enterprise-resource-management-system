package com.serms.config;

import com.serms.entity.Role;
import com.serms.entity.User;
import com.serms.enums.RoleType;
import com.serms.repository.RoleRepository;
import com.serms.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(RoleRepository roleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        createRole(RoleType.ADMIN);
        createRole(RoleType.MANAGER);
        createRole(RoleType.EMPLOYEE);

        if (userRepository.findByEmail("admin@serms.com").isEmpty()) {

            User admin = new User();

            admin.setFullName("System Administrator");
            admin.setEmail("admin@serms.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(roleRepository.findByName(RoleType.ADMIN).get());
            admin.setActive(true);

            userRepository.save(admin);
        }
    }

    private void createRole(RoleType roleType) {

        if (roleRepository.findByName(roleType).isEmpty()) {

            Role role = new Role();

            role.setName(roleType);

            roleRepository.save(role);
        }

    }

}