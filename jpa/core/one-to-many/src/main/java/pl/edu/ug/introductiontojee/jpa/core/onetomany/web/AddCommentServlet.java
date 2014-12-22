package pl.edu.ug.introductiontojee.jpa.core.onetomany.web;

import pl.edu.ug.introductiontojee.jpa.core.onetomany.domain.Comment;
import pl.edu.ug.introductiontojee.jpa.core.onetomany.domain.Message;
import pl.edu.ug.introductiontojee.jpa.core.onetomany.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/comments/add/*")
public class AddCommentServlet extends HttpServlet{
    @EJB
    private MessageStorageService messageStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getID(request);
        Message message = messageStorage.get(messageID);

        String commentText = request.getParameter("message");
        String author = request.getParameter("author");

        Comment comment = new Comment();
        comment.setMessage(commentText);
        comment.setAuthor(author);
        comment.setCreatedAt(new Date());

        messageStorage.addComment(message, comment);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/view/" + messageID));
    }
}
