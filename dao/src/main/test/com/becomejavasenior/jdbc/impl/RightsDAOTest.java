package com.becomejavasenior.jdbc.impl;

import com.becomejavasenior.jdbc.entity.Rights;
import com.becomejavasenior.jdbc.entity.SubjectType;
import com.becomejavasenior.jdbc.entity.User;
import com.becomejavasenior.jdbc.entity.RightsDAO;
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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:application-context-dao.xml")
public class RightsDAOTest {

    @Autowired
    private DataSource dataSource;

    private final PostgresDAOFactory factory;
    private RightsDAO rightsDAO;
    private User defaultUser;
    private SubjectType defaultSubjectType = SubjectType.DEAL;
    private int rightsTestId;

    public RightsDAOTest() {
        factory = new PostgresDAOFactory();
        defaultUser = factory.getUserDAO().getById(1);
        rightsDAO = factory.getRightsDAO();
    }

    @Before
    public void setUp() {
        rightsTestId = 0;
    }

    @After
    public void tearDown() throws SQLException {
        if (rightsTestId > 0) {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("DELETE FROM rights WHERE id = " + Integer.toString(rightsTestId));
            } catch (SQLException e) {
                throw new SQLException("Test Rights clean up failed!", e);
            }
            rightsTestId = 0;
        }
    }

    @Test
    public void testCreate() {
        Rights rightsTest = new Rights();
        Assert.assertTrue("Rights ID before creation must be '0'", rightsTest.getId() == 0);

        try {
            rightsTestId = rightsDAO.insert(rightsTest);
        } catch (Exception e) {
            Assert.assertTrue("Empty rights ID must be '0'", rightsTest.getId() == 0);
        } finally {
            Assert.assertTrue("Empty rights ID must be '0'", rightsTestId == 0);
        }

        rightsTest.setUser(defaultUser);
        rightsTest.setSubjectType(defaultSubjectType);
        rightsTestId = rightsDAO.insert(rightsTest);

        Assert.assertNotNull("Rights creation failed", rightsTest);
        Assert.assertTrue("Rights ID after creation must be not '0'", rightsTestId > 0);
    }

    @Test
    public void testGetByPK() {
        Assert.assertNotNull("Rights read by PK failed", rightsDAO.getById(1));
    }

    @Test
    public void testUpdate() throws SQLException {
        User updatedUser = factory.getUserDAO().getById(2);
        SubjectType updatedSubjectType = SubjectType.COMPANY;

        Rights rightsTest = new Rights();
        rightsTest.setUser(defaultUser);
        rightsTest.setSubjectType(defaultSubjectType);
        rightsTestId = rightsDAO.insert(rightsTest);
        Assert.assertNotNull("Rights before update must not be null", rightsTest);

        rightsTest.setUser(updatedUser);
        rightsTest.setSubjectType(updatedSubjectType);
        rightsTest.setChange(true);
        rightsTest.setCreate(true);
        rightsTest.setDelete(true);
        rightsTest.setExport(true);
        rightsTest.setRead(true);
        rightsDAO.update(rightsTest);

        Rights updatedRights = rightsDAO.getById(rightsTestId);
        Assert.assertNotNull("Rights after update is null", updatedRights);
        Assert.assertEquals("Rights user update failed", updatedUser.getId(), updatedRights.getUser().getId());
        Assert.assertEquals("Rights subject type update failed", updatedSubjectType, updatedRights.getSubjectType());

        Assert.assertEquals("Rights for change object update failed", true, updatedRights.isChange());
        Assert.assertEquals("Rights for create object update failed", true, updatedRights.isCreate());
        Assert.assertEquals("Rights for delete object update failed", true, updatedRights.isDelete());
        Assert.assertEquals("Rights for export object update failed", true, updatedRights.isExport());
        Assert.assertEquals("Rights for read object update failed", true, updatedRights.isRead());
    }

    @Test
    public void testDelete() {
        Rights rightsTest = new Rights();
        rightsTest.setUser(defaultUser);
        rightsTest.setSubjectType(defaultSubjectType);
        rightsTestId = rightsDAO.insert(rightsTest);

        List rightsList = rightsDAO.getAll();
        int oldListSize = rightsList.size();
        Assert.assertTrue("Rights list must not be empty", oldListSize > 0);

        rightsDAO.delete(rightsTestId);
        rightsList = rightsDAO.getAll();
        Assert.assertEquals("Rights delete test failed", 1, oldListSize - rightsList.size());
        Assert.assertNull("Rights delete test failed", rightsDAO.getById(rightsTestId));
    }

    @Test
    public void testGetAll() {
        List<Rights> rightsList = rightsDAO.getAll();
        Assert.assertNotNull("Rights list must not be null", rightsList);
        Assert.assertTrue("Rights list must not be empty", rightsList.size() > 0);
    }

    @Test
    public void testGetByUserId() {
        List<Rights> rightsList = rightsDAO.getRightsByUserId(2);
        Assert.assertNotNull("Rights list must not be null", rightsList);
        Assert.assertTrue("Rights list must not be empty", rightsList.size() > 0);
        for (Rights rights : rightsList) {
            Assert.assertEquals("Rights list contains record for another user", 2, rights.getUser().getId());
        }
    }
}
