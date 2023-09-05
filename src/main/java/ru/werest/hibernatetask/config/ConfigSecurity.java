package ru.werest.hibernatetask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class ConfigSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/products/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .roles("PERSON", "READ")
                .build());

        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build());

        manager.createUser(User.withUsername("ivan")
                .password(passwordEncoder().encode("ivan"))
                .roles("READ")
                .build());

        manager.createUser(User.withUsername("vasua")
                .password(passwordEncoder().encode("vasua"))
                .roles("WRITE")
                .build());

        manager.createUser(User.withUsername("kolya")
                .password(passwordEncoder().encode("kolya"))
                .roles("DELETE")
                .build());

        manager.createUser(User.withUsername("liana")
                .password(passwordEncoder().encode("liana"))
                .roles("WRITE", "DELETE")
                .build());

        manager.createUser(User.withUsername("anna")
                .password(passwordEncoder().encode("anna"))
                .roles("READ", "DELETE")
                .build());

        manager.createUser(User.withUsername("vilada")
                .password(passwordEncoder().encode("vilada"))
                .roles("WRITE", "READ")
                .build());


        return manager;
    }
}
