package com.example.core.service.admin.impl;

import com.example.core.dto.AdminDto;
import com.example.core.entity.Admin;
import com.example.core.enums.UserRole;
import com.example.core.repository.admin.AdminRepository;
import com.example.core.repository.user.AbstractUserRepository;
import com.example.core.service.admin.AdminService;
import com.example.core.service.user.impl.AbstractUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by araksgyulumyan
 * Date - 5/11/18
 * Time - 6:28 PM
 */
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
    public Admin createAdmin(AdminDto adminDto) {
        assertAdminDto(adminDto);
        Admin admin = createNewInstance();
        adminDto.updateDomainModelProperties(admin);
        admin.setUserRole(UserRole.ADMIN);
        admin = getUserRepository().save(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(Long adminId, AdminDto adminDto) {
        assertAdminId(adminId);
        assertAdminDto(adminDto);
        Admin admin = getAdminById(adminId);
        adminDto.updateDomainModelProperties(admin);
        admin.setUserRole(UserRole.ADMIN);
        admin = getUserRepository().save(admin);
        return admin;
    }

    @Override
    public Admin getAdminById(Long adminId) {
        assertAdminId(adminId);
        return getUserRepository().getOne(adminId);
    }

    @Override
    public void removeUserById(Long adminId) {
        assertAdminId(adminId);
        getUserRepository().deleteById(adminId);
    }


    // Utility methods
    private static void assertAdminDto(final AdminDto adminDto) {
        Assert.notNull(adminDto, "User dto should not be null");
        Assert.hasText(adminDto.getPassword(), "User dto password should not be null");
        Assert.hasText(adminDto.getEmail(), "User dto email should not be null");
    }

    private static void assertAdminId(Long adminId) {
        Assert.notNull(adminId, "Admin Id should not be null");
    }
}
