package com.becomejavasenior.jdbctemplate.impl;

import com.becomejavasenior.jdbctemplate.entity.NoTaskDealDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */
@Repository
public class NoTaskDealDAOImpl implements NoTaskDealDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public BigInteger getTotalNoTaskNum() {
        return jdbcTemplate.queryForObject(
                "SELECT count(*) FROM deal " +
                        "LEFT JOIN task ON task.deal_id = deal.id " +
                        "WHERE task.deal_id IS NULL",
                BigInteger.class
        );
    }

    @Override
    public BigInteger getTotalWithTaskNum() {
        return jdbcTemplate.queryForObject(
                "SELECT count(*) FROM deal " +
                        "LEFT JOIN task ON task.deal_id = deal.id ",
                BigInteger.class
        );
    }
}
