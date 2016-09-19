package com.becomejavasenior.jdbc.service.factory;

import com.becomejavasenior.jdbc.service.DealService;
import com.becomejavasenior.jdbc.service.impl.DealServiceImpl;

/**
 * Created by apple on 8/26/16.
 */
public class DealServiceStaticFactoryBeanInst {
    private static DealService dealService = new DealServiceImpl();

    private DealServiceStaticFactoryBeanInst() {

    }

    public static DealService createInstance() {
        return dealService;
    }
}
