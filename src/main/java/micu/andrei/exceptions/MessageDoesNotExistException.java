package micu.andrei.exceptions;

import micu.andrei.model.Message;

public class MessageDoesNotExistException extends RuntimeException {

    public MessageDoesNotExistException(Message message) {
        super("No message found for username "+ message.username() + " at time " + message.timestamp());
    }
}
