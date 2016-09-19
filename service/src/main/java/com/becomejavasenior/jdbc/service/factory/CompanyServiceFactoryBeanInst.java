package com.becomejavasenior.jdbc.service.factory;

import com.becomejavasenior.jdbc.service.CompanyService;
import com.becomejavasenior.jdbc.service.impl.CompanyServiceImpl;

/**
 * Created by apple on 8/26/16.
 */
public class CompanyServiceFactoryBeanInst {
    private static CompanyService companyService = new CompanyServiceImpl();

    private CompanyServiceFactoryBeanInst() {

    }

    public void init() {
        System.out.println("init method of CompanyServiceFactoryBeanInst.class bean");
    }

    public void destroy() {
        System.out.println("destroy method of CompanyServiceFactoryBeanInst.class bean");
    }
    public CompanyService createInstance() {
        return companyService;
    }
}
