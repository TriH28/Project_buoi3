package SurveyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/survey")
public class Survey extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String email     = request.getParameter("email");
        String dob       = request.getParameter("dob");
        String heardFrom = request.getParameter("heardFrom");
        String wantsUpdates = request.getParameter("wantsUpdates");
        String emailOK = request.getParameter("emailOK");
        String contactVia = request.getParameter("contactVia");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Survey Result</title></head><body>");
        out.println("<h1>Thank you for submitting the survey!</h1>");
        out.println("<p>Name: " + firstName + " " + lastName + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Date of Birth: " + dob + "</p>");
        out.println("<p>Heard from: " + heardFrom + "</p>");
        out.println("<p>Wants Updates: " + (wantsUpdates != null ? "Yes" : "No") + "</p>");
        out.println("<p>Email Announcements: " + (emailOK != null ? "Yes" : "No") + "</p>");
        out.println("<p>Contact via: " + contactVia + "</p>");
        out.println("</body></html>");
    }
}
