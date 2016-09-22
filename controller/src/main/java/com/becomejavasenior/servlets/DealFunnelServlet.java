package com.becomejavasenior.servlets;

import com.becomejavasenior.jdbc.entity.Deal;
import com.becomejavasenior.jdbc.entity.Stage;
import com.becomejavasenior.jdbc.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@WebServlet(name = "DealFunnelServlet", urlPatterns = "/dealFunnel")
public class DealFunnelServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger("DealFunnelServlet.class");
    @Autowired
    private DealService dealService;

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
        HttpSession session = request.getSession (false);

        List<Stage> stageList = dealService.getAllStage();
        session.setAttribute("stageList", stageList);
        session.setAttribute("dealService", dealService);

        List<Deal> dealList = dealService.getAll();
        session.setAttribute("dealList", dealList);

        response.sendRedirect("/pages/dealFunnel.jsp");


    }

}