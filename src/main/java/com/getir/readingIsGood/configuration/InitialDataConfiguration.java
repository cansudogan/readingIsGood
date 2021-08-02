package com.getir.readingIsGood.configuration;

import com.getir.readingIsGood.domain.Role;
import com.getir.readingIsGood.domain.User;
import com.getir.readingIsGood.model.enums.ERole;
import com.getir.readingIsGood.repository.IRoleRepository;
import com.getir.readingIsGood.repository.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitialDataConfiguration {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleRepository roleRepository;

    public InitialDataConfiguration(IUserRepository userRepository, PasswordEncoder passwordEncoder, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    @PostConstruct
    public void init() {

        if (roleRepository.findByName(ERole.ROLE_CUSTOMER).isEmpty()){
            Role custRole = new Role();
            custRole.setName(ERole.ROLE_CUSTOMER);
            roleRepository.save(custRole);
        }

        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()){
            Role admRole = new Role();
            admRole.setName(ERole.ROLE_ADMIN);
            roleRepository.save(admRole);
        }
        if(!userRepository.existsByUsername("admin")){
            User adminUser = new User("admin",
                    "admin@getir.com",
                    passwordEncoder.encode("123456"));
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            adminUser.setRoles(roles);
            userRepository.save(adminUser);
        }

        if(!userRepository.existsByUsername("customer")){
            User customerUser = new User("customer",
                    "customer@getir.com",
                    passwordEncoder.encode("123456"));
            Set<Role> customerRoles = new HashSet<>();
            Role customerRole = roleRepository.findByName(ERole.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            customerRoles.add(customerRole);
            customerUser.setRoles(customerRoles);
            userRepository.save(customerUser);
        }

    }


}
