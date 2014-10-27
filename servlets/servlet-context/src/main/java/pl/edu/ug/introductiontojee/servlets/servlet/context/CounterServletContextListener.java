package pl.edu.ug.introductiontojee.servlets.servlet.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class CounterServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[SERVLET CONTEXT] CREATED: " + new Date());

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("counter", new Counter());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("[SERVLET CONTEXT] DESTROYED: " + new Date());
    }
}
