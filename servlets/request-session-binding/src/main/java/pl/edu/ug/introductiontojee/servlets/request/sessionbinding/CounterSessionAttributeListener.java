package pl.edu.ug.introductiontojee.servlets.request.sessionbinding;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

@WebListener
public class CounterSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getValue() instanceof Counter) {
            System.out.println("[SESSION ATTRIBUTE LISTENER] ADDED: " + new Date());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getValue() instanceof Counter) {
            System.out.println("[SESSION ATTRIBUTE LISTENER] REMOVED: " + new Date());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if (event.getValue() instanceof Counter) {
            System.out.println("[SESSION ATTRIBUTE LISTENER] REPLACED: " + new Date());
        }
    }
}
