package com.getir.readingIsGood.service;


import com.getir.readingIsGood.domain.User;
import com.getir.readingIsGood.repository.IUserRepository;
import com.getir.readingIsGood.security.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository IUserRepository;

    public UserDetailsServiceImpl(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

}
