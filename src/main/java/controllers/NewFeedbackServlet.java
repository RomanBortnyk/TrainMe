package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.implementation.FeedbackDao;
import dao.implementation.UserDao;
import model.Feedback;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by romab on 10/27/16.
 */
@WebServlet("/addFeedback")
public class NewFeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);

        int destinationUserId = Integer.parseInt((data.get("destinationUserId").getAsString()));
        String newFeedbackText = data.get("newFeedbacktext").getAsString();

        FeedbackDao feedbackDao = new FeedbackDao();
        UserDao userDao = new UserDao();
        Feedback newFeedback = new Feedback();

        newFeedback.setAuthor((User)request.getSession().getAttribute("currentSessionUser"));
        newFeedback.setUser(userDao.read(destinationUserId));
        newFeedback.setText(newFeedbackText);

        feedbackDao.create(newFeedback);

        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write("nothing");

    }
}
