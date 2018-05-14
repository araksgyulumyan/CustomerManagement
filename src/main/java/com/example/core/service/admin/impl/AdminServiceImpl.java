package com.example.core.service.admin.impl;

import com.example.core.dto.AdminDto;
import com.example.core.entity.Admin;
import com.example.core.repository.admin.AdminRepository;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.admin.AdminService;
import com.example.core.service.user.impl.AbstractUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/11/18
 * Time - 6:28 PM
 */
//todo
public class AdminServiceImpl extends AbstractUserServiceImpl<Admin> implements AdminService {

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
        //todo email
        assertAdminDto(adminDto);
        checkAdminExistenceForEmail(email);
        Admin admin = createNewInstance();
        adminDto.updateDomainModelProperties(admin);
        admin.setEmail(email);
        admin = getUserRepository().save(admin);
        return admin;
    }

    @Override
    @Transactional
    public Admin updateAdmin(Long adminId, AdminDto adminDto) {
        assertAdminId(adminId);
        assertAdminDto(adminDto);
        Admin admin = getAdminById(adminId);
        adminDto.updateDomainModelProperties(admin);
        admin = getUserRepository().save(admin);
        return admin;
    }

    //todo change implementation
    @Override
    public Admin getAdminById(Long adminId) {
        assertAdminId(adminId);
        return getUserRepository().getOne(adminId);
    }

    // todo should be transactional
    @Override
    public void removeUserById(Long adminId) {
        assertAdminId(adminId);
        getUserRepository().deleteById(adminId);
    }


    // Utility methods
    private static void assertAdminDto(final AdminDto adminDto) {
        Assert.notNull(adminDto, "User dto should not be null");
        Assert.hasText(adminDto.getPassword(), "User dto password should not be null");
    }

    private static void assertAdminId(Long adminId) {
        Assert.notNull(adminId, "Admin Id should not be null");
    }

    private void checkAdminExistenceForEmail(String email) {
        final Admin admin = getUserRepository().findByEmail(email);
        if (admin != null) {
            throw new RuntimeException("Email is already taken");
        }
    }
}
