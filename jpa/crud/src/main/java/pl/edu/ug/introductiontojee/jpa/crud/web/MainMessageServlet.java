package pl.edu.ug.introductiontojee.jpa.crud.web;

import pl.edu.ug.introductiontojee.jpa.crud.domain.MessageStorageService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class MainMessageServlet extends HttpServlet{
    @Inject
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("messages", storage.getAllMessages());
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
