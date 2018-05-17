package com.example.api.facade.admin;

import com.example.api.facade.user.AbstractUserFacade;
import com.example.api.model.admin.AdminModel;
import org.springframework.stereotype.Component;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:35 PM
 */

@Component
public interface AdminFacade extends AbstractUserFacade<AdminModel> {
}
