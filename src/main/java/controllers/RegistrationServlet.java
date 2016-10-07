package controllers;

import dao.implementation.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by romab on 10/3/16.
 */
public class RegistrationServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthdayDate = request.getParameter("birthdayDate");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String userType = request.getParameter("optionsRadios");

        UserDao userDao = new UserDao();

        User user = new User(firstName,lastName,birthdayDate,login,password,email,userType);

        if( userDao.isExist(user) ){
            RequestDispatcher rd = request.getRequestDispatcher("views/notifications/registrationError.jsp");
            rd.forward(request,response);


        }else {
            userDao.create(user);
            RequestDispatcher rd = request.getRequestDispatcher("views/notifications/successfulRegistration.jsp");
            rd.forward(request,response);
        }



    }
}
