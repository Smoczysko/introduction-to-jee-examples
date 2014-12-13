package pl.edu.ug.introductiontojee.jpa.onetoone.web;

import pl.edu.ug.introductiontojee.jpa.onetoone.domain.Author;
import pl.edu.ug.introductiontojee.jpa.onetoone.domain.AuthorStorageService;
import pl.edu.ug.introductiontojee.jpa.onetoone.domain.Message;
import pl.edu.ug.introductiontojee.jpa.onetoone.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddMessageServlet extends HttpServlet{
    @EJB
    private MessageStorageService messageStorage;

    @EJB
    private AuthorStorageService authorsStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageText = request.getParameter("message");
        Long authoriId = Long.valueOf(request.getParameter("author"));
        Author author = authorsStorage.get(authoriId);
        String title = request.getParameter("title");

        Message newMessage = new Message();
        newMessage.setAuthor(author);
        newMessage.setMessage(messageText);
        newMessage.setTitle(title);

        messageStorage.add(newMessage);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}
