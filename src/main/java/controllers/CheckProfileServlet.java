package controllers;

import dao.implementation.DisciplineUserLinkDao;
import dao.implementation.FeedbackDao;
import dao.implementation.UserDao;
import model.DisciplineUserLink;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by romab on 10/26/16.
 */
@WebServlet("/profile/*")
public class CheckProfileServlet extends HttpServlet{


    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String pathParts [] = request.getPathInfo().split("/");
        int userId = Integer.parseInt(pathParts[1]);

        UserDao userDao = new UserDao();
        FeedbackDao feedbackDao = new FeedbackDao();
        DisciplineUserLinkDao discUsrLnkDao = new DisciplineUserLinkDao();

        User user = userDao.read(userId);
        List usersFeedbacks = feedbackDao.getUsersFeedbacks(userId);
        List disciplinesLinks = discUsrLnkDao.getUsersDisciplineLinks(userId);

        request.setAttribute("user",user);
        request.setAttribute("users",usersFeedbacks);
        request.setAttribute("disciplinesLinks",disciplinesLinks);

        response.sendRedirect("profile.jsp");


    }


}
