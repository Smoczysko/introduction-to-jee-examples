package pl.edu.ug.introductiontojee.jpa.pagination.web;

import pl.edu.ug.introductiontojee.jpa.pagination.domain.MessageStorageService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit/*")
public class EditMessageServlet extends HttpServlet{
    @Inject
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getMessageID(request);

        request.setAttribute("message", storage.get(messageID));
        request.getRequestDispatcher("/message/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Long messageID = WebUtils.getMessageID(request);

        storage.update(messageID, title, message);

        WebUtils.redirectToMessageView(request, response, messageID);
    }
}
