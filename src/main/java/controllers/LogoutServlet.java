package controllers;

import dao.implementation.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.DigestInputStream;

/**
 * Created by romab on 10/2/16.
 */
public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        session.removeAttribute("currentSessionUser");

        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, response);


    }
}

