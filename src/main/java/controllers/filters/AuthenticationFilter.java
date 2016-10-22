package controllers.filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by romab on 10/9/16.
 */
@WebFilter("/views/userPage.jsp")
public class AuthenticationFilter implements Filter {

    private FilterConfig fc;

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest) request;

        HttpSession session =  httpReq.getSession();

        User currentUser = (User)session.getAttribute("currentSessionUser");

        if ((currentUser == null) || session == null){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/views/notifications/authenticationError.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
// do cleanup stuff
    }

}
