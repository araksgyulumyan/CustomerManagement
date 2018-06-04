package com.example.api.facade.admin.impl;

import com.example.api.facade.admin.AdminFacade;
import com.example.api.model.request.admin.AdminRequestModel;
import com.example.api.model.response.admin.AdminResponseModel;
import com.example.api.model.response.common.ErrorType;
import com.example.core.entity.user.Admin;
import com.example.core.service.admin.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
    public AdminResponseModel create(AdminRequestModel adminRequestModel) {
        Assert.notNull(adminRequestModel, "Request model should not be null");
        final AdminResponseModel responseModel = new AdminResponseModel();
        validateRequest(adminRequestModel, responseModel);
        if (responseModel.hasErrors()) {
            return responseModel;
        }
        final Admin admin = adminService.createAdmin(adminRequestModel.getEmail(), adminRequestModel.getPassword());
        return convertToAdminResponseModel(admin, responseModel);
    }

    @Override
    public void deleteUser(Long adminId) {
        adminService.removeUserById(adminId);
    }

    // Utility methods
    private AdminResponseModel convertToAdminResponseModel(final Admin admin, final AdminResponseModel adminResponseModel) {
        adminResponseModel.setId(admin.getId());
        adminResponseModel.setEmail(admin.getEmail());
        return adminResponseModel;
    }

    private static void validateRequest(final AdminRequestModel adminRequestModel, final AdminResponseModel responseModel) {
        if (StringUtils.isEmpty(adminRequestModel.getEmail())) {
            responseModel.getErrors().add(ErrorType.ADMIN_INVALID_EMAIL);
        }
        if (StringUtils.isEmpty(adminRequestModel.getPassword())) {
            responseModel.getErrors().add(ErrorType.ADMIN_INVALID_PASSWORD);
        }
    }
}
