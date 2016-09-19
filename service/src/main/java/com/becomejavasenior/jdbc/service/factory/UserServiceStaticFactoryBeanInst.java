package com.becomejavasenior.jdbc.service.factory;

import com.becomejavasenior.jdbc.service.UserService;
import com.becomejavasenior.jdbc.service.impl.UserServiceImpl;

/**
 * Created by apple on 8/26/16.
 */
public class UserServiceStaticFactoryBeanInst {

    private static UserService userService = new UserServiceImpl();

    private UserServiceStaticFactoryBeanInst() {

    }

    public static UserService createInstance() {
        return userService;
    }

}
