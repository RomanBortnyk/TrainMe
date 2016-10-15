package controllers;

import dao.implementation.AvatarDao;
import dao.implementation.UserDao;
import model.Avatar;
import model.User;
import org.apache.commons.fileupload.*;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


/**
 * Created by romab on 10/14/16.
 */
@WebServlet("/modify/*")
@MultipartConfig
public class ModifyUsersDataServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathParts[] = request.getPathInfo().split("/");
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentSessionUser");

        if (pathParts[1].equals("avatar")) {

            updateAvatar(request,currentUser);

        }

        if (pathParts[1].equals("discipline")) {

            if (pathParts[2].equals("add")) {

            } else {

            }
        }

        if (pathParts[1].equals("description")) {

        }

        response.sendRedirect("../../views/userPage.jsp");
    }

    public void updateAvatar (HttpServletRequest request, User currentUser){

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        File uploadedFile = null;

        try {

            List items = upload.parseRequest(request);
            Iterator iterator = items.iterator();

            while (iterator.hasNext()) {

                FileItem item = (FileItem) iterator.next();

                if (!item.isFormField()) {
                    String fileName = item.getName();

                    File path = new File("../temporary");

                    if (!path.exists()) {
                        boolean status = path.mkdirs();
                    }

                    uploadedFile = new File(path + "/" + fileName);
                    String s = uploadedFile.getAbsolutePath();
                    System.out.println(uploadedFile.getAbsolutePath());
                    item.write(uploadedFile);
                }
            }
            Avatar newAvatar = new Avatar(uploadedFile);
            UserDao userDao = new UserDao();
            userDao.updateAvatar(currentUser,newAvatar);
            uploadedFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

