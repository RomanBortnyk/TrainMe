package controllers;

import dao.implementation.DisciplineUserLinkDao;
import dao.implementation.UserDao;
import model.DisciplineUserLink;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by romab on 10/17/16.
 */

@WebServlet("/search")
public class SearchServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String searchOption = request.getParameter("");
        String userTypeOption = request.getParameter("");
        String searchString = request.getParameter("searchString");

        HttpSession session = request.getSession();
        List resultList = (List)session.getAttribute("resultList");
        UserDao userDao = new UserDao();
        DisciplineUserLinkDao discUsrLnkDao = new DisciplineUserLinkDao();

        searchOption = "by_discipline";
        userTypeOption = "coach";


//        TODO test this if
        if (searchOption.equals("by_userName")){
            String fullName [] = searchString.split(" ");

            if (resultList == null){
                List temp = userDao.read(fullName[0],fullName[1],userTypeOption);
                session.setAttribute("resultList", temp);
                response.sendRedirect("../../views/searchTest.jsp");

            }else {
                resultList.clear();
                List temp = userDao.read(fullName[0],fullName[1],userTypeOption);
                resultList.addAll(temp);
//                resultList.addAll(userDao.read(fullName[0],fullName[1],userTypeOption));
                response.sendRedirect("../../views/searchTest.jsp");

            }


        }else if (searchOption.equals("by_discipline")){
            if (resultList == null){
                List temp = discUsrLnkDao.find(userTypeOption,searchString);
                session.setAttribute("resultList", temp);
                response.sendRedirect("../../views/searchTest.jsp");
            }else {

                resultList.clear();
                List temp = discUsrLnkDao.find(userTypeOption,searchString);
                resultList.addAll(temp);
                response.sendRedirect("../../views/searchTest.jsp");

            }

        }

    }
}
