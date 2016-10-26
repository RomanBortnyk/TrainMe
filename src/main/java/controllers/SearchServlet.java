package controllers;

import dao.implementation.DisciplineUserLinkDao;
import dao.implementation.UserDao;
import model.DisciplineUserLink;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by romab on 10/17/16.
 */

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchOption = request.getParameter("searchOption");
        String userTypeOption = request.getParameter("userTypeOption");
        String searchString = request.getParameter("searchString");

        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        DisciplineUserLinkDao discUsrLnkDao = new DisciplineUserLinkDao();

        if (searchOption.equals("byFullName")){
            String fullName [] = searchString.split(" ");
            //search by username
            List temp = userDao.read(fullName[0],fullName[1],userTypeOption);
            session.setAttribute("resultMap", generateResultMap(temp, discUsrLnkDao));
            response.sendRedirect("../../views/searchPage.jsp");

        }else if (searchOption.equals("byDiscipline")){
            //search by discipline
            List temp = discUsrLnkDao.find(userTypeOption,searchString);
            session.setAttribute("resultMap", generateResultMap(temp,discUsrLnkDao));
            response.sendRedirect("../../views/searchPage.jsp");

        }
    }

    public HashMap<User, ArrayList<Integer> > generateResultMap (List usersList, DisciplineUserLinkDao disciplineUserLinkDao){
        HashMap<User, ArrayList<Integer> > result = new HashMap<User, ArrayList<Integer>>();

        for (Object user: usersList){
            List userDisciplineLinks = disciplineUserLinkDao.getUsersDisciplineLinks(((User)user).getId());
            ArrayList<Integer> iconsIdsTemp = new ArrayList<Integer>();
            for (Object usrDiscLink: userDisciplineLinks){
                iconsIdsTemp.add(((DisciplineUserLink)usrDiscLink).getDiscipline().getId());
            }
            result.put((User)user,iconsIdsTemp);
        }

        return result;

    }
}
