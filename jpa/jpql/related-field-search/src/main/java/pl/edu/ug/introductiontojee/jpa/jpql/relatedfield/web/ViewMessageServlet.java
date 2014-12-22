package pl.edu.ug.introductiontojee.jpa.jpql.relatedfield.web;

import pl.edu.ug.introductiontojee.jpa.jpql.relatedfield.domain.Message;
import pl.edu.ug.introductiontojee.jpa.jpql.relatedfield.domain.MessageStorageService;

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

        Message message = storage.get(messageID);
        request.setAttribute("message", message);
        request.setAttribute("comments", message.getComments());
        request.getRequestDispatcher("/message/view.jsp").forward(request, response);
    }
}
