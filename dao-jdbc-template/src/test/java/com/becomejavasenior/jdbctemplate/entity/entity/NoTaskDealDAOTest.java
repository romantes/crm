package com.becomejavasenior.jdbctemplate.entity.entity;

import com.becomejavasenior.jdbctemplate.entity.NoTaskDealDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * Created by apple on 9/6/16.
 */

public class NoTaskDealDAOTest extends AbstractDAOJdbcTemplateTest {

    @Autowired
    NoTaskDealDAO noTaskDealDAO;

    @Test
    public void getTotalNoTaskNumTest() {
        BigInteger expected = new BigInteger("4");
        BigInteger actual = noTaskDealDAO.getTotalNoTaskNum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalWithTaskNumTest() {
        BigInteger expected = new BigInteger("3");
        BigInteger actual = noTaskDealDAO.getTotalWithTaskNum();
        Assert.assertEquals(expected, actual);
    }
}
