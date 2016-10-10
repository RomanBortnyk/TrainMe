package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by romab on 10/2/16.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        int a = 1;
        int b = 2;
        System.out.println(a + b);
        session.removeAttribute("currentSessionUser");
        request.getSession().invalidate();

        response.sendRedirect("index.html");

    }
}

