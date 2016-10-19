package controllers;

import dao.implementation.AvatarDao;
import dao.implementation.DisciplineDao;
import dao.implementation.DisciplineUserLinkDao;
import dao.implementation.UserDao;
import model.Avatar;
import model.Discipline;
import model.DisciplineUserLink;
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
        List currentDiscList = (List)session.getAttribute("disciplineLinks");


        if (pathParts[1].equals("avatar")) {

            updateAvatar(request,currentUser);

        }

//        TODO: test this if
//        TODO: remove existing disciplines in user profile from result list

        if (pathParts[1].equals("discipline")) {

            DisciplineDao disciplineDao = new DisciplineDao();
            DisciplineUserLinkDao discUsrLinkDao = new DisciplineUserLinkDao();

            if (pathParts[2].equals("add")) {
                String newDiscName = request.getParameter("disciplineToAdd");
                if (newDiscName == null) response.sendRedirect("../../views/userPage.jsp");

                DisciplineUserLink linkToAdd = new DisciplineUserLink();
                linkToAdd.setUser(currentUser);
                linkToAdd.setDiscipline(disciplineDao.read(newDiscName));

                currentDiscList.add(discUsrLinkDao.create(linkToAdd));

            } else {
                if (pathParts[2].equals("remove")){

                    String disciplineName = request.getParameter("disciplineToRemove");

                    DisciplineUserLink linkToRemove = discUsrLinkDao.read(currentUser, disciplineDao.read(disciplineName));

                    currentDiscList.remove(linkToRemove);
                    discUsrLinkDao.delete(linkToRemove);
                }

            }
        }

        if (pathParts[1].equals("description")) {

            updateDescription(request, currentUser);

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

    public void updateDescription (HttpServletRequest request, User currentUser){

//        String newDescription = request.getParameter("description");
        String newDescription = "new description";
        currentUser.setDescription(newDescription);
        UserDao userDao = new UserDao();
        userDao.update(currentUser);

    }

}
