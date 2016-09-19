package com.becomejavasenior.jdbc.entity;

public interface CompanyDAO extends GenericDAO<Company> {
    void companyTag(Company company, Tag tag);
}
