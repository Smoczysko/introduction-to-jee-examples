package pl.edu.ug.introductiontojee.jpa.core.crud.web;

import pl.edu.ug.introductiontojee.jpa.core.crud.domain.Message;
import pl.edu.ug.introductiontojee.jpa.core.crud.domain.MessageStorageService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddMessageServlet extends HttpServlet{
    @Inject
    private MessageStorageService storage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageText = request.getParameter("message");
        String author = request.getParameter("author");
        String title = request.getParameter("title");

        Message newMessage = new Message();
        newMessage.setAuthor(author);
        newMessage.setMessage(messageText);
        newMessage.setTitle(title);

        storage.add(newMessage);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}
