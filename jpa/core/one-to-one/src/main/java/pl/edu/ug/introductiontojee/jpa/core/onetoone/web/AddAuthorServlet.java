package pl.edu.ug.introductiontojee.jpa.core.onetoone.web;

import pl.edu.ug.introductiontojee.jpa.core.onetoone.domain.Author;
import pl.edu.ug.introductiontojee.jpa.core.onetoone.domain.AuthorStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors/add")
public class AddAuthorServlet extends HttpServlet{
    @EJB
    private AuthorStorageService storage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Author author = new Author();
        author.setName(name);

        storage.add(author);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}
