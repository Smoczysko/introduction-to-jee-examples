package pl.edu.ug.introductiontojee.jpa.core.manytomany.web;

import pl.edu.ug.introductiontojee.jpa.core.manytomany.domain.Message;
import pl.edu.ug.introductiontojee.jpa.core.manytomany.domain.MessageStorageService;
import pl.edu.ug.introductiontojee.jpa.core.manytomany.domain.Tag;
import pl.edu.ug.introductiontojee.jpa.core.manytomany.domain.TagStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/add")
public class AddMessageServlet extends HttpServlet{
    @EJB
    private MessageStorageService messageStorage;

    @EJB
    private TagStorageService tagsStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageText = request.getParameter("message");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String[] tags = request.getParameterValues("tags");

        Message newMessage = new Message();
        newMessage.setAuthor(author);
        newMessage.setMessage(messageText);
        newMessage.setTitle(title);

        if (tags != null && tags.length > 0) {
            List<Tag> tagList = new ArrayList<Tag>();

            for (String tagId : tags) {
                tagList.add(tagsStorage.get(Long.valueOf(tagId)));

            }

            newMessage.setTags(tagList);
        }


        messageStorage.add(newMessage);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}
