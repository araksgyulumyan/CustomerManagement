package com.example.core.dto;

import com.example.core.entity.user.User;

import java.io.Serializable;

/**
 * Created by araksgyulumyan
 * Date - 5/9/18
 * Time - 6:49 PM
 */
public abstract class AbstractUserDto<T extends User> implements Serializable {

    private static final long serialVersionUID = -1253854388955760534L;

}
