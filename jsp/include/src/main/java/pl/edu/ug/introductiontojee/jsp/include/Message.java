package pl.edu.ug.introductiontojee.jsp.include;

import java.io.Serializable;

public class Message implements Serializable {
    private String author;
    private String message;

    public Message() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
