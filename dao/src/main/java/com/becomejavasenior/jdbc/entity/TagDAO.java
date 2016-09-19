package com.becomejavasenior.jdbc.entity;

public interface TagDAO extends GenericDAO<Tag> {
    int insertForCompanyContact(Tag tag, Object object);
}
