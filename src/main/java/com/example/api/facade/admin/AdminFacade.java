package com.example.api.facade.admin;

import com.example.api.model.request.admin.AdminRequestModel;
import com.example.api.model.response.admin.AdminResponseModel;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:35 PM
 */

public interface AdminFacade {

    AdminResponseModel create(final AdminRequestModel adminRequestModel);

    void deleteUser(final Long userId);

}
