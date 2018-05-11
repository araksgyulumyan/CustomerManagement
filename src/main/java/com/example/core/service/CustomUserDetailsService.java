package com.example.core.service;

import com.example.core.entity.Customer;
import com.example.core.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by araksgyulumyan
 * Date - 5/8/18
 * Time - 6:23 PM
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    //todo create UserService which implements AbstractUserService interface
    //todo override getUserByEmail method in UserService so that it returns User object
    //todo change here everything from Customer to User specific things so that we can work with users
    @Autowired
    private CustomerService customerService;

    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final Customer customer = customerService.getUserByEmail(email);
        if(customer == null) {
            throw new RuntimeException("asdasdasd");
        }
        return new CustomerUserDetails(customer);
    }

    public class CustomerUserDetails implements UserDetails {

        private final Customer customer;

        public CustomerUserDetails(final Customer customer) {
            this.customer = customer;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + customer.getUserRole().name()));
        }

        @Override
        public String getPassword() {
            return customer.getPassword();
        }

        @Override
        public String getUsername() {
            return customer.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}