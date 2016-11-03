package messenger.controllers;


import dao.implementation.ChatDao;
import messenger.Database;
import model.Message;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by romab on 10/27/16.
 */
@WebServlet("/sendEvent")
public class ReceiveEventController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sctx = request.getServletContext();
        Database database = (Database)sctx.getAttribute("database");

        User messageAuthor = (User) request.getSession().getAttribute("currentSessionUser");

        Message receivedMessage = new Message();
        receivedMessage.setUser(messageAuthor);
        receivedMessage.setText(request.getParameter("messageText"));

        Date today = new java.util.Date();
        Timestamp timestamp = new Timestamp(today.getTime());
        receivedMessage.setCreatedAt( timestamp);

        ChatDao chatDao = new ChatDao();
        receivedMessage.setChat(chatDao.read(Integer.valueOf(request.getParameter("chatId"))));


        database.addMessage(receivedMessage);

//        System.out.println("sfd");

    }
}
