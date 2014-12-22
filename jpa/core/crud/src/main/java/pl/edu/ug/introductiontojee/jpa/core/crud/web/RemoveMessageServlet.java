package pl.edu.ug.introductiontojee.jpa.core.crud.web;

import pl.edu.ug.introductiontojee.jpa.core.crud.domain.MessageStorageService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/remove/*")
public class RemoveMessageServlet extends HttpServlet{
    @Inject
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getMessageID(request);

        storage.delete(messageID);

        WebUtils.redirectToMainPage(request, response);
    }
}
