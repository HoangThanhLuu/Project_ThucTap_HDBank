package com.example.demoTTS2.configuration;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    private final UserRepo userRepo;

    public SecurityConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Bean
@Primary
public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{return configuration.getAuthenticationManager();};
@Bean
public UserDetailsService userDetailsService() {
    return username -> {
        UserEntity existingUser = userRepo.findByUsername(username);
        if(existingUser == null) {
            return (UserDetails) new UsernameNotFoundException("Cannot find user with username" +username);
        } else { return existingUser; }
    };
}
    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}


