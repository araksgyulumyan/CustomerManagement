package com.example.core.service.admin;

import com.example.core.entity.user.Admin;
import com.example.core.service.user.AbstractUserService;

/**
 * Created by araksgyulumyan
 * Date - 5/11/18
 * Time - 5:08 PM
 */
public interface AdminService extends AbstractUserService<Admin> {

    Admin createAdmin(final String email, final String password);

    Admin getAdminById(final Long adminId);
}
