package com.becomejavasenior.jdbc.service;

import com.becomejavasenior.jdbc.entity.Contact;
import com.becomejavasenior.jdbc.entity.Deal;
import com.becomejavasenior.jdbc.entity.Stage;

import java.util.List;

public interface DealService {
    int insert(Deal t);
    void update(Deal t);
    List<Deal> getAll();
    Deal getById(int id);
    void delete(int id);

    List<Deal> getAllDealsByStage(String stage);
    public List<Stage> getAllStage();
    public List<Contact> getContactsByDealName(String dealName);
    public List<Deal> getDealsForList();
}