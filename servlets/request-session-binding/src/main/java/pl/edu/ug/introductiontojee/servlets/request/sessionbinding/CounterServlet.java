package pl.edu.ug.introductiontojee.servlets.request.sessionbinding;


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
        HttpSession session = request.getSession();

        Counter counter = (Counter) session.getAttribute("counter");
        counter.set(counter.get() + 1);
        session.setAttribute("counter", counter);

        PrintWriter writer = response.getWriter();
        String body = "<html>" +
                "<body>" +
                "<p>Counter: " + counter + "</p>" +
                "<p>Session creation time: " + new Date(session.getCreationTime()) + "</p>" +
                "<p>Last session access time: " + new Date(session.getLastAccessedTime()) + "</p>" +
                "<p>Maximum inactive interval: " + session.getMaxInactiveInterval() + " seconds</p>" +
                "</body>" +
                "</html>";

        writer.println(body);
    }
}

