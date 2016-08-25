package com.becomejavasenior.jdbc.factory;

import com.becomejavasenior.jdbc.entity.*;
import com.becomejavasenior.jdbc.impl.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostgresDAOFactory extends AbstractDAOFactory {

//    public static Connection getConnection() throws SQLException {
//        return ConnectionPool.getConnection();
//    }
    private AbstractApplicationContext context =
        new ClassPathXmlApplicationContext("application-context-dao.xml");

    @Override
    public CompanyDAO getCompanyDAO() {
        return context.getBean(CompanyDAOImpl.class);
    }

    @Override
    public ContactDAO getContactDAO() {
        return context.getBean(ContactDAOImpl.class);
    }

    @Override
    public DealDAO getDealDAO() {
        return context.getBean(DealDAOImpl.class);
    }

    @Override
    public FileDAO getFileDAO() {
        return context.getBean(FileDAOImpl.class);
    }

    @Override
    public NoteDAO getNoteDAO() {
        return context.getBean(NoteDAOImpl.class);
    }

    @Override
    public TaskDAO getTaskDAO() {
        return context.getBean(TaskDAOImpl.class);
    }

    @Override
    public UserDAO getUserDAO() {
        return context.getBean(UserDAOImpl.class);
    }

    @Override
    public StageDAO getStageDAO() {
        return context.getBean(StageDAOImpl.class);
    }

    @Override
    public LanguageDAO getLanguageDAO() {
        return context.getBean(LanguageDAOImpl.class);
    }

    @Override
    public TagDAO getTagDAO() {
        return context.getBean(TagDAOImpl.class);
    }

    @Override
    public CurrencyDAO getCurrencyDAO() {
        return context.getBean(CurrencyDAOImpl.class);
    }

    @Override
    public RightsDAO getRightsDAO() {
        return context.getBean(RightsDAOImpl.class);
    }

    @Override
    public VisitHistoryDAO getVisitHistoryDAO() {
        return context.getBean(VisitHistoryDAOImpl.class);
    }
}
