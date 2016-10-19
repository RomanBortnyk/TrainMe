package controllers;

import com.google.gson.Gson;
import dao.implementation.DisciplineDao;

import model.Discipline;
import model.DisciplineUserLink;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by romab on 10/14/16.
 */
@WebServlet(urlPatterns = "/autocomplete")
public class AutoCompleteServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        try {

            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> result = new ArrayList<String>();

//            String requestParameter = "";
//            if (request.getParameter("disciplines") != null){
//                requestParameter=request.getParameter("disciplines");
//
//                DisciplineDao disciplineDao = new DisciplineDao();
//                List<Discipline> disciplineList =  disciplineDao.readAll();
//                //create list of disciplines names
//                for (Discipline discipline: disciplineList){
//                    list.add(discipline.getName());
//                }
//
//            }else {
//                requestParameter = request.getParameter("users");
//                UserDao userDao = new UserDao();
//                List usersFullNamesList = userDao.readAllFullNames();
//
//                //create list of users  full names
//                for (Object listObject: usersFullNamesList){
//                    Object[] oarray = (Object[]) listObject;
//                    String[] names = Arrays.asList(oarray).toArray(new String[oarray.length]);
//                    list.add(names[1] +" " + names[0]);
//                }
//            }
//
//            System.out.println("Data from ajax call " + requestParameter);
//
//            //create result list
//            Iterator it = list.iterator();
//            while (it.hasNext()) {
//                String current = (String) it.next();
//                if (request.getParameter("disciplines")!= null){
//                    if ( current.toLowerCase().startsWith(requestParameter.toLowerCase() ) ){
//                        result.add(current);
//                    }
//                }else {
//                    String currentParts [] = current.split(" ");
//                    if ( currentParts[0].toLowerCase().startsWith(requestParameter.toLowerCase() )
//                            || currentParts[1].toLowerCase().startsWith(requestParameter.toLowerCase() )){
//                        result.add(current);
//                    }
//                }
//            }

            HttpSession session = request.getSession();
            List<DisciplineUserLink> currentDisciplines =  (List<DisciplineUserLink>) session.getAttribute("disciplineLinks");

            DisciplineDao disciplineDao = new DisciplineDao();
            List<Discipline> disciplineList =  disciplineDao.readAll();
            //create list of disciplines names
            for (Discipline discipline: disciplineList){
                int i=0;
                for (DisciplineUserLink currentDiscLink: currentDisciplines){
                    if (discipline.getName().equals(currentDiscLink.getDiscipline().getName())) i++;

                }
                if (i==0) list.add(discipline.getName());
            }


            Collections.sort(list);
            String searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);

//            String searchList = new Gson().toJson(result);
//            response.getWriter().write(searchList);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
