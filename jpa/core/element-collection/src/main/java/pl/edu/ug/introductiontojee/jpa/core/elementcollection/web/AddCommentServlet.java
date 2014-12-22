package pl.edu.ug.introductiontojee.jpa.core.elementcollection.web;

import pl.edu.ug.introductiontojee.jpa.core.elementcollection.domain.Message;
import pl.edu.ug.introductiontojee.jpa.core.elementcollection.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/comments/add/*")
public class AddCommentServlet extends HttpServlet{
    @EJB
    private MessageStorageService messageStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getID(request);
        Message message = messageStorage.get(messageID);

        String comment = request.getParameter("message");

        messageStorage.addComment(message, comment);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/view/" + messageID));
    }
}
