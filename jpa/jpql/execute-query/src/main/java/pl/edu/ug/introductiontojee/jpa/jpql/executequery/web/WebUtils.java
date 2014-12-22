package pl.edu.ug.introductiontojee.jpa.jpql.executequery.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {
    public static Long getMessageID(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String messageID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());

        return Long.valueOf(messageID);
    }

    public static void redirectToMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }

    public static void redirectToMessageView(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/view/" + id));
    }
}
