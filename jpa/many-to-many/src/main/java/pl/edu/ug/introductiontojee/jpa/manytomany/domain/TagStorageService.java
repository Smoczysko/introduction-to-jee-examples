package pl.edu.ug.introductiontojee.jpa.manytomany.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class TagStorageService {
    @PersistenceContext
    EntityManager em;

    public Tag get(Long id) {
        return em.find(Tag.class, id);
    }

    public void add(String name) {
        Tag tag = new Tag();
        tag.setName(name);

        em.persist(tag);
    }

    public List<Tag> getAllTags(){
        //noinspection unchecked
        return em.createNamedQuery("tag.all").getResultList();
    }
}
