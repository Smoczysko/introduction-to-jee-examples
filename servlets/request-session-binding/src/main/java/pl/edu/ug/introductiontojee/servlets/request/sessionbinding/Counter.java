package pl.edu.ug.introductiontojee.servlets.request.sessionbinding;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.Date;

public class Counter implements HttpSessionBindingListener {
    private int value;

    public Counter () {
        this.value = 0;
    }

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("[SESSION BINDING LISTENER] Value bounded: " + new Date());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("[SESSION BINDING LISTENER] Value unbounded: " + new Date());
    }
}
