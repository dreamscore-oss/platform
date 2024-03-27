package com.dreamscore.backend.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Profile("!dev")
    @Bean
    public SecurityFilterChain secureFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(
                authorize ->
                    authorize
                        .requestMatchers("/api/**")
                        .authenticated()
                        .requestMatchers("/docs/**")
                        .hasAnyAuthority("SCOPE_read:docs")
            )
            .cors(withDefaults())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
            .build();
    }

    @Profile("dev")
    @Bean
    public SecurityFilterChain devFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
            .cors(withDefaults())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
            .build();
    }
}
