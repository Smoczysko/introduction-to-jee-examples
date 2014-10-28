package pl.edu.ug.introductiontojee.jsp.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class ListMessagesTag extends TagSupport {
    private List<Message> messages;

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter jspWriter = pageContext.getOut();

        try {
            jspWriter.println("<table class=\"table table-striped\">");

            jspWriter.println("<tr>");
            jspWriter.println("<th>#</th>");
            jspWriter.println("<th>Author</th>");
            jspWriter.println("<th>Message</th>");
            jspWriter.println("</tr>");

            for (int i = 0; i < messages.size(); i++) {
                jspWriter.println("<tr>");
                jspWriter.println("<td>" + (i + 1) + "</td>");
                jspWriter.println("<td>" + messages.get(i).getAuthor() + "</td>");
                jspWriter.println("<td>" + messages.get(i).getMessage() + "</td>");
                jspWriter.println("</tr>");
            }

            jspWriter.println("</table>");

        } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }

        return SKIP_BODY;
    }
}
