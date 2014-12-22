package pl.edu.ug.introductiontojee.jpa.jpql.relatedfield.web;

import pl.edu.ug.introductiontojee.jpa.jpql.relatedfield.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class SearchMessageServlet extends HttpServlet{
    @EJB
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
            return;
        }

        request.setAttribute("type", type);

        if (type.equals("commentAuthor")) {
            String author = request.getParameter("author");
            request.setAttribute("messages", storage.getAllWithCommentsByAuthor(author));
            request.setAttribute("headerText", "Messages with comments by " + author);
        }

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
