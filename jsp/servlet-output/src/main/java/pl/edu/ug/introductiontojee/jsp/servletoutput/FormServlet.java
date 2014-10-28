package pl.edu.ug.introductiontojee.jsp.servletoutput;


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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.setAttribute("isUnderage", request.getParameter("underage") != null);

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

        request.setAttribute("hobbies", selectedHobbies);

        String name = request.getParameter("name");
        if (name == null || name.equals("")) {
            name = "not provided";
        }

        request.setAttribute("name", name);
        request.setAttribute("fruit", request.getParameter("fruit"));

        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
}

