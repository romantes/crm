package com.becomejavasenior.service.factory;

import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.impl.ContactServiceImpl;

/**
 * Created by apple on 8/26/16.
 */
public class ContactServiceFactoryBeanInst {
    private static ContactService contactService = new ContactServiceImpl();

    private ContactServiceFactoryBeanInst() {

    }

    public ContactService createInstance() {
        return contactService;
    }
}
