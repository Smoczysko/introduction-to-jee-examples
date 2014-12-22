package pl.edu.ug.introductiontojee.jpa.datessearch.web;

import pl.edu.ug.introductiontojee.jpa.datessearch.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/view/*")
public class ViewMessageServlet extends HttpServlet{
    @EJB
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getMessageID(request);

        request.setAttribute("message", storage.get(messageID));
        request.getRequestDispatcher("/message/view.jsp").forward(request, response);
    }
}
