package controllers;

import model.User;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by romab on 10/3/16.
 */
public class DownloadAvatarServlet extends HttpServlet  {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("currentSessionUser");
        byte[] content = user.getAvatar().getImage();
        response.setContentType(getServletContext().getMimeType("alt"));
        response.setContentLength(content.length);
        response.getOutputStream().write(content);
    }
}
