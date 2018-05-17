package com.example.core.service.admin.impl;

import com.example.core.dto.AdminDto;
import com.example.core.entity.user.Admin;
import com.example.core.repository.admin.AdminRepository;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.admin.AdminService;
import com.example.core.service.user.impl.AbstractUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/11/18
 * Time - 6:28 PM
 */

@Service
public class AdminServiceImpl extends AbstractUserServiceImpl<Admin> implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminRepository adminRepository;

    // Abstract methods
    @Override
    protected Admin createNewInstance() {
        return new Admin();
    }

    @Override
    protected AbstractUserRepository<Admin> getUserRepository() {
        return adminRepository;
    }

    // Service methods
    @Override
    @Transactional
    public Admin createAdmin(String email, AdminDto adminDto) {
        assertEmail(email);
        assertAdminDto(adminDto);
        checkAdminExistenceForEmail(email);
        Admin admin = createNewInstance();
        final String encodedPassword = passwordEncoder.encode(adminDto.getPassword());
        admin.setEmail(email);
        admin.setPassword(encodedPassword);
        admin = getUserRepository().save(admin);
        return admin;
    }

    @Override
    public Admin getAdminById(Long adminId) {
        assertAdminId(adminId);
        return getUserRepository().getOne(adminId);
    }

    @Override
    @Transactional
    public void removeUserById(Long adminId) {
        assertAdminId(adminId);
        getUserRepository().deleteById(adminId);
    }

    // Utility methods
    private static void assertAdminDto(final AdminDto adminDto) {
        Assert.notNull(adminDto, "User dto should not be null");
        Assert.hasText(adminDto.getPassword(), "User dto password should not be empty");
    }

    private static void assertAdminId(Long adminId) {
        Assert.notNull(adminId, "Admin Id should not be null");
    }

    private static void assertEmail(String email) {
        Assert.hasText(email, "Email should not be null");
    }

    private void checkAdminExistenceForEmail(String email) {
        final Admin admin = getUserRepository().findByEmail(email);
        if (admin != null) {
            LOGGER.error("message");
            throw new RuntimeException("Email is already taken");
        }
    }
}
