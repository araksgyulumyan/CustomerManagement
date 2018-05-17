package com.example.core.repository.admin;

import com.example.core.entity.user.Admin;
import com.example.core.repository.user.AbstractUserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 7:22 PM
 */
@Repository
public interface AdminRepository extends AbstractUserRepository<Admin> {
}
