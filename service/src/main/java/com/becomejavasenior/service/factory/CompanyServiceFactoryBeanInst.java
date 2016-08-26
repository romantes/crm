package com.becomejavasenior.service.factory;

import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;

/**
 * Created by apple on 8/26/16.
 */
public class CompanyServiceFactoryBeanInst {
    private static CompanyService companyService = new CompanyServiceImpl();

    private CompanyServiceFactoryBeanInst() {

    }

    public CompanyService createInstance() {
        return companyService;
    }
}
