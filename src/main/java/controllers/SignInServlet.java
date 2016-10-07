package controllers;
import model.User;
import dao.implementation.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by romab on 10/1/16.
 */
public class SignInServlet extends HttpServlet{


    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        UserDao userDAO = new UserDao();
        String login = request.getParameter("login");
        User user = userDAO.read(login);

        RequestDispatcher rd2 = request.getRequestDispatcher("views/notifications/signInError.jsp");

        if (user != null){
            if (userDAO.isPasswordCorrect(user, request.getParameter("password"))){

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                RequestDispatcher rd = request.getRequestDispatcher("views/userPage.jsp");
                rd.forward(request,response);

            }else {
                request.setAttribute("incorrectPass", true);
                rd2.forward(request,response);
            }

        }else {
            request.setAttribute("unexistLogin", true);
            rd2.forward(request,response);
        }


    }



}
