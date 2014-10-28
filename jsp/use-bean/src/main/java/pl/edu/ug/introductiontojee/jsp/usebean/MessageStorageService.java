package pl.edu.ug.introductiontojee.jsp.usebean;

import java.util.ArrayList;
import java.util.List;

public class MessageStorageService {
    private List<Message> messages = new ArrayList<Message>();

    public void add(Message message) {
        messages.add(message);
    }

    public List<Message> getAllMessages(){
        return messages;
    }
}
