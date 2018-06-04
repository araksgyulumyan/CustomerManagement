package com.example.api.controller.admin;

import com.example.api.facade.admin.AdminFacade;
import com.example.api.model.request.admin.AdminRequestModel;
import com.example.api.model.response.admin.AdminResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/admin", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody AdminResponseModel createAdmin(@RequestBody final AdminRequestModel adminRequestModel) {
        return adminFacade.create(adminRequestModel);
    }
}
