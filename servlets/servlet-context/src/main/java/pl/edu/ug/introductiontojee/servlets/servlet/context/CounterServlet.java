package pl.edu.ug.introductiontojee.servlets.servlet.context;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/")
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        Counter counter = (Counter) servletContext.getAttribute("counter");
        counter.set(counter.get() + 1);
        servletContext.setAttribute("counter", counter);

        PrintWriter writer = response.getWriter();
        String body = "<html>" +
                "<body>" +
                "<p>Counter: " + counter + "</p>" +
                "<p>Context path: " + servletContext.getContextPath() + "</p>" +
                "<p>Server info: " + servletContext.getServerInfo() + "</p>" +
                "</body>" +
                "</html>";

        writer.println(body);
    }
}

