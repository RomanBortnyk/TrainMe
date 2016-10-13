package ajaxTest;

import com.google.gson.Gson;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by romab on 10/14/16.
 */
@WebServlet(urlPatterns = "/SearchController")
public class AutoCompleteServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        try {
            String name = request.getParameter("term");
            System.out.println("Data from ajax call " + name);



            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> result = new ArrayList<String>();


            list.add("Spring");
            list.add("String");
            list.add("Maven");
            list.add("Git");
            list.add("Gradle");
            list.add("Hibarnate");
            list.add("Heroku");
            list.add("Suzzy");
            list.add("Starbucks");

            Iterator it = list.iterator();

            while (it.hasNext()) {

                String current = (String) it.next();

                if ( current.toLowerCase().startsWith(name)){
                    // targetId matches first name


                    result.add(current);
                }

                                // targetId matches last name
//                                tempName.toLowerCase().startsWith(name) ||
//                                // targetId matches full name
//                                tempName.toLowerCase().concat(" ")
//                                        .concat(tempName.toLowerCase()).startsWith(targetId))


            }


            String searchList = new Gson().toJson(result);
            response.getWriter().write(searchList);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
