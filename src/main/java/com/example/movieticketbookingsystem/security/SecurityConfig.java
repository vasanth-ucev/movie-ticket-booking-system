package com.example.movieticketbookingsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //disable csrf protection
        http.csrf(csrf->csrf.disable());

        //specify public & private routes
        http.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.POST,"/register")
                .permitAll()
                .anyRequest().authenticated()           );

        //type of authentication to be done
        http.formLogin((Customizer.withDefaults()));

        //return
        return  http.build();

    }


}
