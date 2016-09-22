package com.becomejavasenior.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by apple on 9/20/16.
 */
@WebFilter(filterName = "localeToSessionFilter", urlPatterns = "/*")
public class LocaleToSessionFilter implements Filter {
    private static final String LOCALE_QUERY_PARAM = "lang";
    private static final String LOCALE_DEFAULT = "en_US";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Locale locale;
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        String localeName = request.getParameter(LOCALE_QUERY_PARAM);
        locale = new Locale(LOCALE_DEFAULT);

        if (localeName != null) {
            locale = new Locale(localeName);
            if (session != null) {
                session.setAttribute(LOCALE_QUERY_PARAM, locale);
            }
        } else {
            if (session != null) {
                Locale inSessionLocale = (Locale) session.getAttribute(LOCALE_QUERY_PARAM);
                if (inSessionLocale == null) {
                    session.setAttribute(LOCALE_QUERY_PARAM, locale);
                } else {
                    locale = inSessionLocale;
                }
            }
        }

        request.setAttribute("javax.servlet.jsp.jstl.fmt.locale.request", locale);

        if (session != null) {
            request.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", locale);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
