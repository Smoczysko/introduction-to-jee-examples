package pl.edu.ug.introductiontojee.jaxrs.responsecode.api;

import pl.edu.ug.introductiontojee.jaxrs.responsecode.domain.Message;
import pl.edu.ug.introductiontojee.jaxrs.responsecode.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("messages")
public class MessagesResource {
    @EJB
    MessageStorageService messageStorageService;

    @GET
    public List<Message> getAllMessages() {
        return messageStorageService.getAllMessages();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Message message = messageStorageService.get(id);

        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PUT
    public Response addMessage(
            @FormParam("author") String author,
            @FormParam("title") String title,
            @FormParam("message") String message) {

        Message newMessage = new Message();
        newMessage.setAuthor(author);
        newMessage.setTitle(title);
        newMessage.setMessage(message);

        messageStorageService.add(newMessage);

        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Message message = messageStorageService.get(id);

        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        messageStorageService.delete(message);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("{id}")
    public Response editMessage(
            @PathParam("id") Long id,
            @FormParam("author") String author,
            @FormParam("title") String title,
            @FormParam("message") String messageText) {

        Message message = messageStorageService.get(id);

        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        message.setAuthor(author);
        message.setTitle(title);
        message.setMessage(messageText);

        messageStorageService.update(message);

        return Response.status(Response.Status.OK).build();
    }
}
