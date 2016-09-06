package com.becomejavasenior.jdbctemplate.entity.entity;

import com.becomejavasenior.jdbctemplate.entity.CompletedDealDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */

public class CompletedDealDAOTest extends AbstractDAOJdbcTemplateTest {

    @Autowired
    CompletedDealDAO completedDealDAO;

    @Test
    public void getTotalCompletedNumTest() {
        BigInteger expected = new BigInteger("0");
        BigInteger actual = completedDealDAO.getTotalCompletedNum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalIncompletedNumTest() {
        BigInteger expected = new BigInteger("0");
        BigInteger actual = completedDealDAO.getTotalIncomletedNum();
        Assert.assertEquals(expected, actual);
    }
}
