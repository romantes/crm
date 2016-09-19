package com.becomejavasenior.jdbc.service.factory;

import com.becomejavasenior.jdbc.service.ContactService;
import com.becomejavasenior.jdbc.service.impl.ContactServiceImpl;

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
