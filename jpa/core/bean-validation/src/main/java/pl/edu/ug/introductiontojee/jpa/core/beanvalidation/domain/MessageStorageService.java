package pl.edu.ug.introductiontojee.jpa.core.beanvalidation.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MessageStorageService {
    @PersistenceContext
    EntityManager em;

    public Message get(Long id) {
        return em.find(Message.class, id);
    }

    public PersistenceActionStatus add(Message message) {
        message.setId(null);
        PersistenceActionStatus status = new PersistenceActionStatus();

        try {
            em.persist(message);
        } catch (ConstraintViolationException ex) {
            status.setSuccess(false);

            ArrayList<String> errors = new ArrayList<String>();
            for (ConstraintViolation violation : ex.getConstraintViolations()) {
                System.out.println();
                errors.add(violation.getPropertyPath().toString() + " " + violation.getMessage() + ".");
            }
            status.setErrors(errors);
        }

        return status;
    }

    public List<Message> getAllMessages(){
        //noinspection unchecked
        return em.createNamedQuery("message.all").getResultList();
    }
}
