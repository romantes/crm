package com.becomejavasenior.service.factory;

import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.UserServiceImpl;

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
