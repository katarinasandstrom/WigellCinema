package org.sandstrom.wigellcinema.security;

import jakarta.persistence.Column;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration

public class SecurityConfig {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    public SecurityConfig() {
        logger.info("SecurityConfig instantiated");
    }

    //    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(userDetailsManager(dataSource())).passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, true FROM customer WHERE username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT username,role FROM customer WHERE username=?");

        return jdbcUserDetailsManager;
    }


    @Autowired
    private DataSource dataSource;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.POST, "/api/v1/cinvenbookings").hasRole("USER")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/cinvenbookings/*").hasRole("USER")
                                .requestMatchers(HttpMethod.GET, "/api/v1/cinvenbookings/customer/*").hasRole("USER")

                                .requestMatchers(HttpMethod.GET, "/api/v1/movies").hasAnyRole("USER", "ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/v1/cinema/customers").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/cinema/customers").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/cinema/customers/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/cinema/customers/*").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.POST, "/api/v1/movies").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/movies/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/movies/*").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.PUT, "/api/v1/cinema/rooms/*").hasRole("ADMIN")

                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());


        return http.build();
    }
}




