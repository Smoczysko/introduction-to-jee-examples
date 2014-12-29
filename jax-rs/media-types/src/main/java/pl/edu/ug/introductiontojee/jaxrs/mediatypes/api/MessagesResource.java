package pl.edu.ug.introductiontojee.jaxrs.mediatypes.api;

import pl.edu.ug.introductiontojee.jaxrs.mediatypes.domain.Message;
import pl.edu.ug.introductiontojee.jaxrs.mediatypes.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("messages")
@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public class MessagesResource {
    @EJB
    MessageStorageService messageStorageService;

    @GET
    public List<Message> getAllMessages() {
        return messageStorageService.getAllMessages();
    }

    @GET
    @Path("{id}")
    public Message get(@PathParam("id") Long id) {
        return messageStorageService.get(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addMessage(
            @FormParam("author") String author,
            @FormParam("title") String title,
            @FormParam("message") String message) {

        Message newMessage = new Message();
        newMessage.setAuthor(author);
        newMessage.setTitle(title);
        newMessage.setMessage(message);

        messageStorageService.add(newMessage);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        messageStorageService.delete(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{id}")
    public void editMessage(
            @PathParam("id") Long id,
            @FormParam("author") String author,
            @FormParam("title") String title,
            @FormParam("message") String messageText) {

        Message message = messageStorageService.get(id);

        if (message != null) {
            message.setAuthor(author);
            message.setTitle(title);
            message.setMessage(messageText);

            messageStorageService.update(message);
        }
    }
}
