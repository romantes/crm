package com.becomejavasenior.jdbc.impl;

import com.becomejavasenior.jdbc.entity.*;
import com.becomejavasenior.jdbc.entity.NoteDAO;
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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:application-context-dao.xml")
public class NoteDAOTest {

    @Autowired
    private DataSource dataSource;

    private static final String DEFAULT_NOTE_TEXT = "Default Note Text";
    private static final Date DEFAULT_DATE = new Timestamp(new Date().getTime());
    private final PostgresDAOFactory factory;
    private NoteDAO noteDAO;
    private User userForNoteTest;
    private int noteTestId;


    public NoteDAOTest() {
        factory = new PostgresDAOFactory();
        userForNoteTest = factory.getUserDAO().getById(1);
        noteDAO = factory.getNoteDAO();
    }

    @Before
    public void setUp() {
        noteTestId = 0;
    }

    @After
    public void tearDown() throws SQLException {
        if (noteTestId > 0) {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("DELETE FROM note WHERE id = " + Integer.toString(noteTestId));
            } catch (SQLException e) {
                throw new SQLException("Test Note clean up failed!", e);
            }
            noteTestId = 0;
        }
    }

    @Test
    public void testCreate() {
        Note noteTest = new Note();
        Assert.assertTrue("Note ID before creation must be '0'", noteTest.getId() == 0);

        try {
            noteTestId = noteDAO.insert(noteTest);
        } catch (Exception e) {
            Assert.assertTrue("Empty note ID must be '0'", noteTest.getId() == 0);
        } finally {
            Assert.assertTrue("Empty note ID must be '0'", noteTestId == 0);
        }

        noteTest.setNote(DEFAULT_NOTE_TEXT);
        noteTest.setDateCreate(DEFAULT_DATE);
        noteTest.setCreator(userForNoteTest);
        noteTestId = noteDAO.insert(noteTest);

        Assert.assertNotNull("Note creation failed", noteTest);
        Assert.assertTrue("Note ID after creation must be not '0'", noteTestId > 0);
        Assert.assertNotNull("Note date of creation must be not null", noteTest.getDateCreate());
        Assert.assertNotNull("Note creator must be not null", noteTest.getCreator());
    }

    @Test
    public void testGetByPK() {
        Assert.assertNotNull("Note read by PK failed", noteDAO.getById(1));
    }

    @Test
    public void testUpdate() throws SQLException {
        String updatedNoteText = "Updated\nNote\nText";
        Timestamp updatedCreateDate = new Timestamp(1L << 41);
        User userForTestUpdate = factory.getUserDAO().getById(2);
        Company companyForTestUpdate = factory.getCompanyDAO().getById(2);
        Contact contactForTestUpdate = factory.getContactDAO().getById(2);
        Deal dealForTestUpdate = factory.getDealDAO().getById(2);

        Note noteTest = new Note();
        noteTest.setNote(DEFAULT_NOTE_TEXT);
        noteTest.setDateCreate(DEFAULT_DATE);
        noteTest.setCreator(userForNoteTest);
        noteTestId = noteDAO.insert(noteTest);
        Assert.assertNotNull("Note before update must not be null", noteTest);

        noteTest.setNote(updatedNoteText);
        noteTest.setDateCreate(updatedCreateDate);
        noteTest.setCreator(userForTestUpdate);
        noteTest.setCompany(companyForTestUpdate);
        noteTest.setContact(contactForTestUpdate);
        noteTest.setDeal(dealForTestUpdate);

        noteDAO.update(noteTest);

        Note updatedNote = noteDAO.getById(noteTestId);
        Assert.assertNotNull("Note after update is null", updatedNote);
        Assert.assertEquals("Notename update failed", updatedNoteText, updatedNote.getNote());
        Assert.assertEquals("Date of note creation update failed", updatedCreateDate, updatedNote.getDateCreate());
        Assert.assertEquals("Note creator update failed", userForTestUpdate.getId(), updatedNote.getCreator().getId());
        Assert.assertEquals("Note link to Company update failed", companyForTestUpdate.getId(), updatedNote.getCompany().getId());
        Assert.assertEquals("Note link to Contact update failed", contactForTestUpdate.getId(), updatedNote.getContact().getId());
        Assert.assertEquals("Note link to Deal update failed", dealForTestUpdate.getId(), updatedNote.getDeal().getId());
    }

    @Test
    public void testDelete() {
        Note noteTest = new Note();
        noteTest.setNote(DEFAULT_NOTE_TEXT);
        noteTest.setDateCreate(DEFAULT_DATE);
        noteTest.setCreator(userForNoteTest);
        noteTestId = noteDAO.insert(noteTest);

        List noteList = noteDAO.getAll();
        int oldListSize = noteList.size();
        Assert.assertTrue("Note list must not be empty", oldListSize > 0);

        noteDAO.delete(noteTestId);
        noteList = noteDAO.getAll();
        Assert.assertEquals("Note delete test failed", 1, oldListSize - noteList.size());
        Assert.assertNull("Note delete test failed", noteDAO.getById(noteTestId));
    }

    @Test
    public void testGetAll() {
        List noteList = noteDAO.getAll();
        Assert.assertNotNull("Note list must not be null", noteList);
        Assert.assertTrue("Note list must not be empty", noteList.size() > 0);
    }
}
