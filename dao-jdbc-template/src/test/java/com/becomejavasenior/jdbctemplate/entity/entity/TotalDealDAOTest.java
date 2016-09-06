package com.becomejavasenior.jdbctemplate.entity.entity;

import com.becomejavasenior.jdbctemplate.entity.TotalDealDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */

public class TotalDealDAOTest extends AbstractDAOJdbcTemplateTest{

    @Autowired
    TotalDealDAO totalDealDAO;

    @Test
    public void getTotalNumDealsTest() {
        BigInteger expected = new BigInteger("3");
        BigInteger actual = totalDealDAO.getTotalNumOfDeals();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalDealBudgetTest() {
        BigDecimal expected = new BigDecimal("30330.25");
        BigDecimal actual = totalDealDAO.getTotalDealBudget();
        Assert.assertEquals(expected, actual);
    }
}
