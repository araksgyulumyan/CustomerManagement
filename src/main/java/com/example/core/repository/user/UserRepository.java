package com.example.core.repository.user;

import com.example.core.entity.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 3:49 PM
 */
@Repository
public interface UserRepository extends AbstractUserRepository<User> {
}
