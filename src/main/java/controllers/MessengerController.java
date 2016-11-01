package controllers;

import dao.implementation.ChatDao;
import model.Chat;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by romab on 11/1/16.
 */
@WebServlet("/messenger")
public class MessengerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ChatDao chatDao = new ChatDao();
        HttpSession session = request.getSession();
        List<Chat> chats = chatDao.getUserChats ( ((User)session.getAttribute("currentSessionUser")).getId() );
        session.setAttribute("usersChatsList", chatDao.getUserChats( ((User)session.getAttribute("currentSessionUser")).getId() ) );

        response.sendRedirect("../../views/conversations.jsp");


    }
}
