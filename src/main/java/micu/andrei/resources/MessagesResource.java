package micu.andrei.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
}
