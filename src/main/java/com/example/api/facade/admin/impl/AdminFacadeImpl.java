package com.example.api.facade.admin.impl;

import com.example.api.facade.admin.AdminFacade;
import com.example.api.model.admin.AdminModel;
import com.example.core.dto.AdminDto;
import com.example.core.entity.user.Admin;
import com.example.core.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:58 PM
 */

@Component
public class AdminFacadeImpl implements AdminFacade {

    @Autowired
    private AdminService adminService;

    // Interface public methods overrides
    @Override
    public AdminModel create(String email, AdminModel adminModel) {
        Admin admin = adminService.createAdmin(email, toAdminDto(adminModel));
        return convertToAdminModel(admin);
    }

    @Override
    public AdminModel update(Long adminId, AdminModel adminModel) {
        final Admin admin = adminService.updateUser(adminId, toAdminDto(adminModel));
        return convertToAdminModel(admin);
    }

    @Override
    public void deleteUser(Long adminId) {
        adminService.removeUserById(adminId);
    }

    // Utility methods
    private static AdminDto toAdminDto(final AdminModel adminModel) {
        return (AdminDto) new AdminDto().setPassword(adminModel.getPassword());
    }

    private AdminModel convertToAdminModel(Admin admin) {
        return (AdminModel) new AdminModel().setEmail(admin.getEmail());
    }
}
