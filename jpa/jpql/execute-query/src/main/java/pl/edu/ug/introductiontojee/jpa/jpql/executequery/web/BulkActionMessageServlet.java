package pl.edu.ug.introductiontojee.jpa.jpql.executequery.web;

import pl.edu.ug.introductiontojee.jpa.jpql.executequery.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bulk")
public class BulkActionMessageServlet extends HttpServlet {
    @EJB
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("delete")) {
            String author = request.getParameter("author");

            storage.deleteAllMessagesByAuthor(author);
        }

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("rename")) {
            String author = request.getParameter("author");
            String newName = request.getParameter("newName");

            storage.updateMessagesAuthorName(author, newName);

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/search?type=author&author=" + newName));
        } else {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
        }
    }
}