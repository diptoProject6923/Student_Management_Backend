package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;

    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
       var user= User.withUsername("farhan")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();

       var user1=User.withUsername("tanvir")
               .password(passwordEncoder.encode("2312"))
               .roles("USER")
               .build();



       return new InMemoryUserDetailsManager(user,user1);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/students/public/**").permitAll()
                        .requestMatchers("/students/admin", "/students/admin/**").hasRole("ADMIN")
                        .requestMatchers("/students/user/**").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
