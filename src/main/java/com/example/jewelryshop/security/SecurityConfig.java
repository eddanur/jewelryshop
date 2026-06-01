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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // Tarayıcının ürünleri çekmesine izin veren kalkan
                .csrf(csrf -> csrf.disable()) // Geliştirme aşamasında olduğumuz için kapalı
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // H2 Console'un ekranda açılabilmesi için
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // H2 veritabanı paneline şifresiz giriş izni

                        // --- HOCANIN İSTEDİĞİ 8. MADDE: RBAC (ROLE-BASED ACCESS CONTROL) ---
                        // 1. Kural: Vitrindeki ürünleri (GET istekleri) herkes şifresiz GÖREBİLİR.
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()

                        // 2. Kural: Ekleme (POST), Silme (DELETE) ve Güncelleme (PUT) işlemlerini SADECE "ADMIN" rolü yapabilir.
                        .requestMatchers("/api/products/**").hasRole("ADMIN")
                        // --------------------------------------------------------------------

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Temel kullanıcı adı/şifre penceresi çıkarır

        return http.build();
    }

    // Tarayıcımıza güvenli olduğunu söyleyen ayar listesi
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // Herhangi bir yerden gelen isteği kabul et
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Sistem Yöneticisi (Admin Rolü)
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123") // {noop} şifreyi kriptolamadan düz okumasını sağlar
                .roles("ADMIN")
                .build();

        // Normal Müşteri (User Rolü)
        UserDetails user = User.builder()
                .username("musteri")
                .password("{noop}musteri123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}