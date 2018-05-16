package com.example.core.repository.user;

import com.example.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 3:26 PM
 */
public interface AbstractUserRepository<T extends User> extends JpaRepository<T, Long> {

    T findByEmail(String email);
}
