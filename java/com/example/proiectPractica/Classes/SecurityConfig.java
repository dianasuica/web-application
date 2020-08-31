package com.example.proiectPractica.Classes;

import com.example.proiectPractica.Service.UserService;
import org.hibernate.annotations.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("dianaUser")
//                .password("{noop}secret050")
//                .roles()
//                .and()
//                .withUser("cataUser")
//                .password("{noop}agent007")
//                .roles();
//    }


    @Bean
    public UserDetailsService userDetailsService() {return new UserService();}


    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider DaoauthenticationProvider()
    {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder());
        auth.setUserDetailsService(userDetailsService());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(DaoauthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/clienti/all").hasRole("ADMIN")//ce as fi vrut aici era ca daca nu am ADMIN sa nu poata accesa pagina de clienti si sa se duca pe pagina noAcces. PB e ca inca acceseaza
                                                                       // pagina de clienti, dar fara sa mai apara datele lor
             // .antMatchers("/**").hasRole("ADMIN")             //daca pun doar "/**" functioneaza sa nu mai acceseze de la inceput nici pagina principala de index si sa apara pagina noAccess

                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll().failureForwardUrl("/login_error")
                .and()
                .logout().clearAuthentication(true).permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/noAccess");  //pagina unde voiam sa se redirectioneze daca nu are rol de ADMIN
    }
}
