package micu.andrei.exceptions;

import micu.andrei.model.Message;

public class MessageAlreadyExistsException extends RuntimeException {

    public MessageAlreadyExistsException(Message message) {
        super("A message for username "+ message.username() + " at time " + message.timestamp() + " already exists");
    }
}
