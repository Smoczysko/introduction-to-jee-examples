package pl.edu.ug.introductiontojee.jpa.core.ejb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries({
    @NamedQuery(name = "message.all", query = "select m from Message m order by m.id")
})
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;
    private String message;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
