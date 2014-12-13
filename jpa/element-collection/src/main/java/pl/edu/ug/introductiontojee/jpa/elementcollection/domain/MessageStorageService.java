package pl.edu.ug.introductiontojee.jpa.elementcollection.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class MessageStorageService {
    @PersistenceContext
    EntityManager em;

    public Message get(Long id) {
        return em.find(Message.class, id);
    }

    public void add(Message message) {
        message.setId(null);
        message.setCreatedAt(new Date());

        em.persist(message);
    }

    public void addComment(Message message, String comment) {
        List<String> comments = message.getComments();
        comments.add(comment);

        message.setComments(comments);

        em.merge(message);
    }

    public List<Message> getAllMessages(){
        //noinspection unchecked
        return em.createNamedQuery("message.all").getResultList();
    }
}
