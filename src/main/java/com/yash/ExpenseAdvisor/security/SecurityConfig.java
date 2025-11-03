//package com.yash.ExpenseAdvisor.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
//        this.customUserDetailsService = customUserDetailsService;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(customUserDetailsService);
//        provider.setPasswordEncoder(passwordEncoder());
//        return provider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            .authenticationProvider(authenticationProvider())
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/register", "/login", "/logout-success", "/css/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/expenses/view", false) // 🚀 critical
//                .failureUrl("/login?error=true")
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .permitAll()
//            );
//        return http.build();
//    }
//}
