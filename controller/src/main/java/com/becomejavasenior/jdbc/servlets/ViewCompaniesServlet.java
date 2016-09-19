package com.becomejavasenior.jdbc.servlets;

import com.becomejavasenior.jdbc.entity.Company;
import com.becomejavasenior.jdbc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ViewCompaniesServlet extends HttpServlet {

    @Autowired
    private CompanyService companyService;

    public void init(ServletConfig config) {
        try {
            super.init(config);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companyList = companyService.getAll();
        companyList.sort((Company company1, Company company2) -> company1.getName().compareTo(company2.getName()));
        request.setAttribute("companyList", companyList);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/viewcompanies.jsp");
        requestDispatcher.forward(request, response);
    }
}