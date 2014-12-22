package pl.edu.ug.introductiontojee.jpa.core.onetoone.web;

import pl.edu.ug.introductiontojee.jpa.core.onetoone.domain.AuthorStorageService;
import pl.edu.ug.introductiontojee.jpa.core.onetoone.domain.MessageStorageService;

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
    private MessageStorageService messageStorage;

    @EJB
    private AuthorStorageService authorStorage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("messages", messageStorage.getAllMessages());
        request.setAttribute("authors", authorStorage.getAllAuthors());
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
