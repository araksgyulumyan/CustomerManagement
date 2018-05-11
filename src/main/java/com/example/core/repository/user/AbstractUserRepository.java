package com.example.core.repository.user;

import com.example.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 3:26 PM
 */
@Repository
public interface AbstractUserRepository<T extends User> extends JpaRepository<T, Long> {

    T findByEmail(String email);

    T findByType(String type);

}
