package com.example.movieticketbookingsystem.security;

import com.example.movieticketbookingsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.movieticketbookingsystem.entity.UserDetails details =userRepository.findByEmail(username);
        if(details==null)
            throw new UsernameNotFoundException("user not found by this email: "+ username);
       return User.builder()
                .username(details.getEmail())
                .password(details.getPassword())
               .authorities(details.getRole().name())
                .build();

    }
}
