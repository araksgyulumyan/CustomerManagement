package com.example.api.controller.admin;

import com.example.api.facade.admin.AdminFacade;
import com.example.api.model.request.admin.AdminRequestModel;
import com.example.api.model.response.admin.AdminResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 5/17/18
 * Time - 5:25 PM
 */

@Controller
public class AdminController {

    @Autowired
    private AdminFacade adminFacade;

    // Endpoints
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public AdminResponseModel createAdmin(
            @Valid AdminRequestModel adminRequestModel) {

        AdminResponseModel adminResponseModel = new AdminResponseModel();
        List<String> errors = new ArrayList<>();
        if (assertAdminRequestModel(adminRequestModel)) {
            errors.add("Please enter email");
            errors.add("Please enter password");
            adminResponseModel.setErrors(errors);
        }

        // Create admin
        return adminFacade.create(adminRequestModel.getEmail(), adminRequestModel);
    }


    //Utility methods
    private static boolean assertAdminRequestModel(AdminRequestModel adminRequestModel) {
        return (adminRequestModel.getEmail().isEmpty() || adminRequestModel.getPassword().isEmpty());
    }

}
