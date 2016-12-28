package controllers;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by romab on 9/19/16.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doPost (HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException {

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/jsp/result.jsp");
        view.forward(request, response);

        //something sdf
        //sdf sd fsdfsfd


    }

    public void doGet (HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "suka" + "</h1>");

    }

}
