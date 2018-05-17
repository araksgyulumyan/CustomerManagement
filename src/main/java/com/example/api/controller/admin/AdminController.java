package com.example.api.controller.admin;

import com.example.api.facade.admin.AdminFacade;
import com.example.api.model.admin.AdminModel;
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
    public AdminModel createAdmin(
            @Valid AdminModel adminModel) {

        List<String> errors = new ArrayList<>();
        if (adminModel.getEmail().isEmpty() || adminModel.getPassword().isEmpty()) {
            errors.add("Please, fill in ");
            return (AdminModel) new AdminModel().setErrors(errors);
        }
        // Create admin
        return adminFacade.create(adminModel.getEmail(), adminModel);
    }
}
