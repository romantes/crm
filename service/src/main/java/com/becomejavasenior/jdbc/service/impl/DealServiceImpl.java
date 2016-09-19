package com.becomejavasenior.jdbc.service.impl;

import com.becomejavasenior.jdbc.entity.Contact;
import com.becomejavasenior.jdbc.entity.Deal;
import com.becomejavasenior.jdbc.entity.Stage;
import com.becomejavasenior.jdbc.entity.DealDAO;
import com.becomejavasenior.jdbc.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class DealServiceImpl implements DealService {

    @Autowired
    private DealDAO dealDao;
    private Deal deal;

    @Override
    public int insert(Deal deal) {
        return dealDao.insert(deal);
    }

    @Override
    public List<Deal> getAllDealsByStage(String stage) {
        return dealDao.getDealsByStage(stage);
    }
    @Override
    public List<Contact> getContactsByDealName(String dealName) {
        return dealDao.getContactsByDealName(dealName);
    }

    @Override
    public List<Stage> getAllStage() {
        return dealDao.getAllStage();
    }

    @Override
    public List<Deal> getDealsForList() {
        return dealDao.getDealsForList();
    }

    @Override
    public void update(Deal deal) {
        dealDao.update(deal);
    }

    @Override
    public List<Deal> getAll() {
        return dealDao.getAll();
    }

    @Override
    public Deal getById(int id) {
        return dealDao.getById(id);
    }

    @Override
    public void delete(int id) {
        dealDao.delete(id);
    }
}
