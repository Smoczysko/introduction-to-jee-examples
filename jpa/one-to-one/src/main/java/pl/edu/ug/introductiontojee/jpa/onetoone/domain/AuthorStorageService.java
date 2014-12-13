package pl.edu.ug.introductiontojee.jpa.onetoone.domain;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.Date;
import java.util.List;

@Stateless
public class AuthorStorageService {
    @PersistenceContext
    EntityManager em;

    public Author get(Long id) {
        return em.find(Author.class, id);
    }

    public void add(Author author) {
        author.setId(null);

        em.persist(author);
    }

    public List<Author> getAllAuthors(){
        //noinspection unchecked
        return em.createNamedQuery("author.all").getResultList();
    }
}
