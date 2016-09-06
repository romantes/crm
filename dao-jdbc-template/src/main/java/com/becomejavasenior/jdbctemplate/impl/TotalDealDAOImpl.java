package com.becomejavasenior.jdbctemplate.impl;

import com.becomejavasenior.jdbctemplate.entity.TotalDealDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by apple on 9/5/16.
 */
@Repository
public class TotalDealDAOImpl implements TotalDealDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public BigInteger getTotalNumOfDeals() {
        return jdbcTemplate.queryForObject(
                "SELECT count(*) FROM deal",
                BigInteger.class
        );
    }

    @Override
    public BigDecimal getTotalDealBudget() {
        return jdbcTemplate.queryForObject(
                "SELECT sum(amount) FROM deal",
                BigDecimal.class
        );
    }
}

