package controllers;

import dao.implementation.DisciplineDao;
import dao.implementation.UserDao;
import model.Discipline;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by romab on 10/9/16.
 */
@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {


    public void doGet (HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{

        String pathParts [] = request.getPathInfo().split("/");

        if (pathParts[1].equals("avatar")){
            UserDao userDao = new UserDao();
            User user = userDao.read(Integer.valueOf(pathParts[2]));

            byte[] content = user.getAvatar().getImage();
            response.setContentLength(content.length);
            response.getOutputStream().write(content);

        }else {
            DisciplineDao disciplineDao = new DisciplineDao();
            Discipline discipline = disciplineDao.read(Integer.valueOf(pathParts[2]));

            byte[] content = discipline.getIcon();
            response.setContentLength(content.length);
            response.getOutputStream().write(content);
        }

    }
}
