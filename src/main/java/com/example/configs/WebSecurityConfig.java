package com.example.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by araksgyulumyan
 * Date - 5/8/18
 * Time - 5:42 PM
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("customUserDetailsService")
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**", "/**").permitAll()
                .and().httpBasic().disable().antMatcher("/**").authorizeRequests()
//                .antMatchers("/admin/**", "/newuser").access("hasRole('ADMIN')")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username").passwordParameter("password")
                .and().csrf().disable();
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
