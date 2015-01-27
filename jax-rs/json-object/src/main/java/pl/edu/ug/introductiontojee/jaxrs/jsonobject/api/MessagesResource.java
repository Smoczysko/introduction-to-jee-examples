package pl.edu.ug.introductiontojee.jaxrs.jsonobject.api;

import pl.edu.ug.introductiontojee.jaxrs.jsonobject.domain.Message;
import pl.edu.ug.introductiontojee.jaxrs.jsonobject.domain.MessageStorageService;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResource {
    @EJB
    MessageStorageService messageStorageService;

    @GET
    public Response getAllMessages() {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        List<Message> messages = messageStorageService.getAllMessages();

        for (Message message : messages) {
            jsonArrayBuilder.add(message.toJsonObject());
        }

        return Response.status(Response.Status.OK).entity(jsonArrayBuilder.build()).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Message message = messageStorageService.get(id);

        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(message.toJsonObject()).build();
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
