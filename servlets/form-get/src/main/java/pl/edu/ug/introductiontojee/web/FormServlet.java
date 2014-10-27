package pl.edu.ug.introductiontojee.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        boolean isUnderAge = (request.getParameter("underage") != null);
        String[] requestHobbies = request.getParameterValues("hobbies");

        String selectedHobbies = "";
        if (requestHobbies == null) {
            selectedHobbies = "none selected";
        } else {
            for (String hobby: requestHobbies) {
                selectedHobbies += hobby + ", ";
            }

            selectedHobbies = selectedHobbies.substring(0, selectedHobbies.length() - 2);
        }

        String name = request.getParameter("name");
        if (name == null || name.equals("")) {
            name = "not provided";
        }

        String body = "<html><body>" +
                "Name: " + name + "<br/>" +
                "Fruit: " + request.getParameter("fruit") + "<br/>" +
                "Is under age: " + isUnderAge + "<br/>" +
                "Hobbies: " + selectedHobbies + "<br/>" +
                "</body></html>";

        PrintWriter writer = response.getWriter();
        writer.println(body);

        writer.close();
    }
}

