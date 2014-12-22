package pl.edu.ug.introductiontojee.jpa.core.manytomany.web;

import pl.edu.ug.introductiontojee.jpa.core.manytomany.domain.TagStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/tags/add")
public class AddTagServlet extends HttpServlet{
    @EJB
    private TagStorageService tagsStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        tagsStorage.add(name);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}
