package pl.edu.ug.introductiontojee.jpa.jpql.executequery.web;

import pl.edu.ug.introductiontojee.jpa.jpql.executequery.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class MainMessageServlet extends HttpServlet{
    @EJB
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String current = request.getParameter("page");
        if (current == null) {
            current = "1";
        }
        int currentPage = Integer.valueOf(current);

        request.setAttribute("currentPage", currentPage);

        long totalPages = (long) Math.ceil(storage.getCount() / 10.0);
        request.setAttribute("totalPages", totalPages);

        request.setAttribute("messages", storage.getMessages((currentPage - 1) * 10, 10));
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
