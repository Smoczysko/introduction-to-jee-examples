package pl.edu.ug.introductiontojee.jaxrs.jsonobject.domain;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MessageStorageService {
    private List<Message> messages = new ArrayList<Message>();
    private Long counter = (long) 0;

    public void add(Message message) {
        message.setId(counter);
        messages.add(message);

        counter++;
    }

    public Message get(Long id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                return message;
            }
        }

        return null;
    }

    public void delete(Message message) {
        messages.remove(message);
    }

    public void update(Message message) {
        messages.set(messages.indexOf(message), message);
    }

    public List<Message> getAllMessages(){
        return messages;
    }
}
