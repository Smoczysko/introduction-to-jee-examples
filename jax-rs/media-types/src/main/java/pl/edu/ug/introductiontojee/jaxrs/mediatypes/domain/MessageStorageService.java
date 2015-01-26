package pl.edu.ug.introductiontojee.jaxrs.mediatypes.domain;

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

    public void delete(Long id) {
        for (Message message : messages) {
            if (message.getId().equals(id)) {
                messages.remove(message);
                return;
            }
        }
    }

    public void update(Message message) {
        messages.set(messages.indexOf(message), message);
    }

    public List<Message> getAllMessages(){
        return messages;
    }
}
