package pl.edu.ug.introductiontojee.jpa.jpql.sqlqueries.domain;

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

    public void update(Long id, String title, String message) {
        Message msg = em.find(Message.class, id);
        msg.setTitle(title);
        msg.setMessage(message);

        em.merge(msg);
    }

    public void delete(Long id) {
        Message message = em.find(Message.class, id);
        em.remove(message);
    }

    public List<Message> getAllMessages(){
        //noinspection unchecked
        return em.createNamedQuery("message.all").getResultList();
    }

    public List<Message> getMessages(int offset, int limit){
        //noinspection unchecked
        return em.createNamedQuery("message.all").
                setFirstResult(offset).
                setMaxResults(limit).
                getResultList();
    }

    public Long getCount() {
        return (Long) em.createQuery("select count(m) from Message m").getSingleResult();
    }

    public void addComment(Message message, Comment comment) {
        List<Comment> comments = message.getComments();
        comments.add(comment);

        message.setComments(comments);

        em.merge(message);
    }

    public List<Message> getAllWithCommentsByAuthor(String author) {
        //noinspection unchecked
        return em.createQuery("SELECT DISTINCT m from Message m JOIN FETCH m.comments comment where comment.author = :author").
                setParameter("author", author).getResultList();
    }
}
