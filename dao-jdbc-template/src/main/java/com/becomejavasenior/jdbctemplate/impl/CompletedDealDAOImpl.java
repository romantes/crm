package com.becomejavasenior.jdbctemplate.impl;

import com.becomejavasenior.jdbctemplate.entity.CompletedDealDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */

@Repository
public class CompletedDealDAOImpl implements CompletedDealDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public BigInteger getTotalCompletedNum() {
        return jdbcTemplate.queryForObject(
                "SELECT count(*)  " +
                        "FROM deal LEFT JOIN stage_deals " +
                        "ON deal.stage_id = stage_deals.id " +
                        "WHERE stage_deals.name = 'Успешно реализовано'" ,
                BigInteger.class
        );
    }

    @Override
    public BigInteger getTotalIncomletedNum() {
        return jdbcTemplate.queryForObject(
                "SELECT count(*)  " +
                "FROM deal LEFT JOIN stage_deals " +
                "ON deal.stage_id = stage_deals.id " +
                "WHERE stage_deals.name = 'Закрыто и не реализовано'" ,
                BigInteger.class
        );
    }

}
