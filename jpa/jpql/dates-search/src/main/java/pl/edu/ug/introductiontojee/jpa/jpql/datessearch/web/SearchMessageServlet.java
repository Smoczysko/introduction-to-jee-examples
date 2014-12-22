package pl.edu.ug.introductiontojee.jpa.jpql.datessearch.web;

import pl.edu.ug.introductiontojee.jpa.jpql.datessearch.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/search")
public class SearchMessageServlet extends HttpServlet{
    @EJB
    private MessageStorageService storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
            return;
        }

        request.setAttribute("type", type);

        if (type.equals("date")) {
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            Date fromDate = null, toDate = null;

            try {
                if (!from.equals("")) {
                    fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
                }

                if (!to.equals("")) {
                    toDate = new SimpleDateFormat("yyyy-MM-dd").parse(to);
                }

                if (!from.equals("") && !to.equals("")) {
                    request.setAttribute("messages", storage.getBetweenDates(fromDate, toDate));
                    request.setAttribute("headerText", "Messages between " + from + " and " + to);
                } else if (to.equals("")) {
                    request.setAttribute("messages", storage.getAfterDate(fromDate));
                    request.setAttribute("headerText", "Messages after " + from);
                } else {
                    request.setAttribute("messages", storage.getBeforeDate(toDate));
                    request.setAttribute("headerText", "Messages before " + to);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
