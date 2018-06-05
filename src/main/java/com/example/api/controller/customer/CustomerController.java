package com.example.api.controller.customer;

import com.example.api.facade.customer.CustomerFacade;
import com.example.api.model.request.customer.CustomerRequestModel;
import com.example.api.model.response.customer.CustomerResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 6/5/18
 * Time - 7:59 PM
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    // Endpoints
    @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CustomerResponseModel createCustomer(@RequestBody final CustomerRequestModel customerRequestModel) {
        return customerFacade.createCustomer(customerRequestModel);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CustomerResponseModel updateCustomer(@RequestBody final CustomerRequestModel customerRequestModel) {
        return customerFacade.updateCustomer(customerRequestModel.getId(), customerRequestModel);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CustomerResponseModel> getCustomers(@RequestBody final Integer limit, final Integer offset) {
        return customerFacade.getLimitedCustomers(limit, offset);
    }
}
