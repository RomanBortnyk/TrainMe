package controllers;
import dao.implementation.DisciplineUserLinkDao;
import dao.implementation.FeedbackDao;
import model.DisciplineUserLink;
import model.User;
import dao.implementation.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by romab on 10/1/16.
 */
@WebServlet("/signIn")
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

                FeedbackDao feedbackDao = new FeedbackDao();
                List feedbacks = feedbackDao.getUsersFeedbacks(user.getId());

                DisciplineUserLinkDao disUslinkDao = new DisciplineUserLinkDao();
                List disciplineLinks = disUslinkDao.getUsersDisciplineLinks(user.getId());

                session.setAttribute("disciplineLinks", disciplineLinks);
                session.setAttribute("usersFeedbacks", feedbacks);

                response.sendRedirect("views/userPage.jsp");

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
