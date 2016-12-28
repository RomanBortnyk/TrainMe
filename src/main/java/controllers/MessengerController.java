package controllers;

import com.google.gson.Gson;
import dao.implementation.ChatDao;
import dao.implementation.MessageDao;
import model.Chat;
import model.Message;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by romab on 11/1/16.
 */
@WebServlet("/messenger/*")
public class MessengerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathParts[] = request.getPathInfo().split("/");


        if (pathParts[1].equals("usersChatsList")) {

            ChatDao chatDao = new ChatDao();
            HttpSession session = request.getSession();
            List<Chat> chats = chatDao.getUserChats ( ((User)session.getAttribute("currentSessionUser")).getId() );
            session.setAttribute("usersChatsList", chatDao.getUserChats( ((User)session.getAttribute("currentSessionUser")).getId() ) );

            response.sendRedirect("../../views/conversations.jsp");


        }

        if (pathParts[1].equals("chatMessages")) {
            int chatId = Integer.parseInt(pathParts[2]);

            MessageDao messageDao = new MessageDao();


            String messagesList = new Gson().toJson(messageDao.getChatMessages(chatId));

            response.getWriter().write(messagesList);

        }

    }
}
