package micu.andrei.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import micu.andrei.model.Message;
import micu.andrei.store.MessageStore;

import java.util.Collection;

@Path("/messages")
public class MessagesResource {

    private final MessageStore store;

    public MessagesResource(MessageStore store) {
        this.store = store;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Message> getMessages() {
        return store.getAllMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createMessage(Message message) {
        store.addMessage(message);
    }

    @PATCH
    @Path("/{username}/{timestamp}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateMessage(@PathParam("username") String username, @PathParam("timestamp") Long timestamp, Message message) {
        store.updateMessageText(new Message(username, message.text(), timestamp));
    }

    @DELETE
    @Path("/{username}/{timestamp}")
    public void deleteMessage(@PathParam("username") String username, @PathParam("timestamp") Long timestamp) {
        store.deleteMessage(username, timestamp);
    }
}
