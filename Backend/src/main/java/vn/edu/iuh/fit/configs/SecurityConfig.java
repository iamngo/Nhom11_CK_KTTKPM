package vn.edu.iuh.fit.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import vn.edu.iuh.fit.services.JpaUserDetalsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private JpaUserDetalsService jpaUserDetalsService;
    
    public SecurityConfig(JpaUserDetalsService jpaUserDetalsService) {
        this.jpaUserDetalsService = jpaUserDetalsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            // .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
            .authorizeRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
            )
            .userDetailsService(jpaUserDetalsService)
            // .headers(header -> header
            //     .frameOptions().sameOrigin()
            // )
            // .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
        .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}