package pl.edu.ug.introductiontojee.jaxrs.client.api;

import pl.edu.ug.introductiontojee.jaxrs.client.domain.Message;
import pl.edu.ug.introductiontojee.jaxrs.client.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import java.util.ArrayList;
import java.util.List;

@Path("messages")
public class MessagesResource {
    @EJB
    MessageStorageService messageStorageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages() {
        return messageStorageService.getAllMessages();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
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

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(
            @QueryParam("start") int start,
            @QueryParam("end") int end) {

        List<Message> messages = new ArrayList<Message>();
        Client client = ClientBuilder.newClient();

        for (int i = start; i < end; i++) {
            Message message = client.target("http://localhost:8080/client/api/messages/" + i).request().get(Message.class);

            messages.add(message);
        }

        return Response.status(Response.Status.OK).entity(messages).build();
    }
}
