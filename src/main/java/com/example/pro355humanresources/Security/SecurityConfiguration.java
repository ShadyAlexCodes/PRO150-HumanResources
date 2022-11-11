package com.example.pro355humanresources.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ethan")
                .password(passwordEncoder().encode("password"))
                .authorities("USER");
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/test").permitAll()
                .antMatchers("/index.html").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable() // Disable cross site request forgery checking
                .sessionManagement().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .authenticationEntryPoint(new IgnoreBasicAuthenticatioEntryPoint());



        // .antMatchers("/path/*") // Single path with one sub folder: /path/{id}
        // .antMatchers("/path/*", RequestMethod.GET) // sepcifcy the protocol
        // .antMatchers("/path/**") // Recursively applies to all sub folders.
        // .antMatchers(HttpMethod.GET, "/api/ships/*", "/api/people/).permitAll() //
        // .antMatchers(HttpMethod.GET, "/api/login).autenticated()
    }

    public class IgnoreBasicAuthenticatioEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authenticationException) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
        }
    }

}

