package Test_Management_App.Security;

import Test_Management_App.Model.UserEmployee;
import Test_Management_App.Payloads.UserEmployeeLoginPayload;
import Test_Management_App.Service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserEmployeeService userEmployeeService;


    @Autowired
    public SecurityConfig(UserEmployeeService userEmployeeService) {
        this.userEmployeeService = userEmployeeService;

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            UserEmployee userEmployee = userEmployeeService.getUserEmployeeByUserLogin(username);
            if (userEmployee == null) {
                throw new UsernameNotFoundException("User not found");
            }

            return new org.springframework.security.core.userdetails.User(
                    username,
                    userEmployee.getUserPassword(),
                    Collections.emptyList() // Pusta lista nie jest konieczna
            );
        }).passwordEncoder(passwordEncoder());


    }
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login","/userEmployee/create").permitAll()
                //.anyRequest().authenticated()
                .and()
                .csrf().disable().headers().frameOptions().disable();
    }
}