package com.becomejavasenior.jdbc.impl;

import com.becomejavasenior.entity.*;
import com.becomejavasenior.jdbc.entity.DealDAO;
import com.becomejavasenior.jdbc.factory.PostgresDAOFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:application-context-dao.xml")
public class DealDAOTest {

    private static final String DEFAULT_NAME = "Default Name";
    private static final Date DEFAULT_DATE = new Timestamp(new Date().getTime());

    @Autowired
    private DataSource dataSource;

    private final PostgresDAOFactory factory;
    private DealDAO dealDAO;
    private User userForDealTest;
    private Stage stageForDealTest;
    private Company companyForDealTest;
    private int dealTestId;


    public DealDAOTest() {
        factory = new PostgresDAOFactory();
        userForDealTest = factory.getUserDAO().getById(1);
        stageForDealTest = factory.getStageDAO().getById(1);
        companyForDealTest = factory.getCompanyDAO().getById(1);
        dealDAO = factory.getDealDAO();
    }

    @Before
    public void setUp() {
        dealTestId = 0;
    }

    @After
    public void tearDown() throws SQLException {
        if (dealTestId > 0) {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("DELETE FROM deal WHERE id = " + Integer.toString(dealTestId));
            } catch (SQLException e) {
                throw new SQLException("Test Deal clean up failed!", e);
            }
            dealTestId = 0;
        }
    }

    @Test
    public void testCreate() {
        Deal dealTest = new Deal();
        Assert.assertTrue("Deal ID before creation must be '0'", dealTest.getId() == 0);

        try {
            dealTestId = dealDAO.insert(dealTest);
        } catch (Exception e) {
            Assert.assertTrue("Empty deal ID must be '0'", dealTest.getId() == 0);
        } finally {
            Assert.assertTrue("Empty deal ID must be '0'", dealTestId == 0);
        }

        dealTest.setName(DEFAULT_NAME);
        dealTest.setStage(stageForDealTest);
        dealTest.setCompany(companyForDealTest);
        dealTest.setDateCreate(DEFAULT_DATE);
        dealTest.setCreator(userForDealTest);
        dealTestId = dealDAO.insert(dealTest);

        Assert.assertNotNull("Deal creation failed", dealTest);
        Assert.assertTrue("Deal ID after creation must be not '0'", dealTestId > 0);
        Assert.assertNotNull("Deal date of creation must be not null", dealTest.getDateCreate());
        Assert.assertNotNull("Deal creator must be not null", dealTest.getCreator());
    }

    @Test
    public void testGetByPK() {
        Assert.assertNotNull("Deal read by PK failed", dealDAO.getById(1));
    }

    @Test
    public void testUpdate() throws SQLException {
        String updatedName = "Updated Name";
        Timestamp updatedCreateDate = new Timestamp(1L << 41);
        User updatedUser = factory.getUserDAO().getById(2);
        Company updatedCompany = factory.getCompanyDAO().getById(2);
        Stage updatedStage = factory.getStageDAO().getById(2);
        Contact updatedContact = factory.getContactDAO().getById(2);

        Deal dealTest = new Deal();
        dealTest.setName(DEFAULT_NAME);
        dealTest.setDateCreate(DEFAULT_DATE);
        dealTest.setCreator(userForDealTest);
        dealTest.setCompany(companyForDealTest);
        dealTest.setStage(stageForDealTest);
        dealTestId = dealDAO.insert(dealTest);
        Assert.assertNotNull("Deal before update must not be null", dealTest);

        dealTest.setName(updatedName);
        dealTest.setDateCreate(updatedCreateDate);
        dealTest.setCreator(updatedUser);
        dealTest.setResponsibleUser(updatedUser);
        dealTest.setCompany(updatedCompany);
        dealTest.setStage(updatedStage);
        dealTest.setAmount(BigDecimal.valueOf(500.55));
        dealTest.setPrimaryContact(updatedContact);

        dealDAO.update(dealTest);

        Deal updatedDeal = dealDAO.getById(dealTestId);
        Assert.assertNotNull("Deal after update is null", updatedDeal);
        Assert.assertEquals("Deal name update failed", updatedName, updatedDeal.getName());
        Assert.assertEquals("Date of deal creation update failed", updatedCreateDate, updatedDeal.getDateCreate());
        Assert.assertEquals("Deal creator update failed", updatedUser.getId(), updatedDeal.getCreator().getId());
        Assert.assertEquals("Deal responsible user update failed", updatedUser.getId(), updatedDeal.getResponsibleUser().getId());
        Assert.assertEquals("Deal link to Company update failed", updatedCompany.getId(), updatedDeal.getCompany().getId());
        Assert.assertEquals("Deal link to Stage update failed", updatedStage.getId(), updatedDeal.getStage().getId());
        Assert.assertEquals("getAmount: ", BigDecimal.valueOf(500.55), updatedDeal.getAmount());
        Assert.assertEquals("Deal link to Primary Contact update failed", updatedContact.getId(), updatedDeal.getPrimaryContact().getId());
    }

    @Test
    public void testDelete() {
        Deal dealTest = new Deal();
        dealTest.setName(DEFAULT_NAME);
        dealTest.setDateCreate(DEFAULT_DATE);
        dealTest.setCreator(userForDealTest);
        dealTest.setCompany(companyForDealTest);
        dealTest.setStage(stageForDealTest);
        dealTestId = dealDAO.insert(dealTest);

        List dealList = dealDAO.getAll();
        int oldListSize = dealList.size();
        Assert.assertTrue("Deal list must not be empty", oldListSize > 0);

        dealDAO.delete(dealTestId);
        dealList = dealDAO.getAll();
        Assert.assertEquals("Deal delete test failed", 1, oldListSize - dealList.size());
        Assert.assertNull("Deal delete test failed", dealDAO.getById(dealTestId));
    }

    @Test
    public void testGetAll() {
        List dealList = dealDAO.getAll();
        Assert.assertNotNull("Deal list must not be null", dealList);
        Assert.assertTrue("Deal list must not be empty", dealList.size() > 0);
    }
}
