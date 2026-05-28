package com.example.jewelryshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Geliştirme aşamasında olduğumuz için kapalı
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll() // Herkes ürünleri GÖREBİLİR
                        .requestMatchers("/api/products/**").hasRole("ADMIN") // Ekleme, Silme, Güncelleme sadece ADMIN yapabilir
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Temel kullanıcı adı/şifre penceresi çıkarır

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Dükkanın Patronu (Admin)
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123") // {noop} şifreyi kriptolamadan düz okumasını sağlar (proje için)
                .roles("ADMIN")
                .build();

        // Normal Müşteri (User)
        UserDetails user = User.builder()
                .username("musteri")
                .password("{noop}musteri123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}