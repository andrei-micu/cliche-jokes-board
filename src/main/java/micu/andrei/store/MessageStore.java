package micu.andrei.store;

import micu.andrei.exceptions.MessageAlreadyExistsException;
import micu.andrei.exceptions.MessageDoesNotExistException;
import micu.andrei.model.Message;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This is not how I write code normally. In this case I just try to fit in a timebox.
 */
public class MessageStore {

    private final Map<String, Message> notNeedForMoreThanAMap = new HashMap<>();

    public Collection<Message> getAllMessages() {

        return notNeedForMoreThanAMap.values();
    }

    public void createMessage(Message message) {

        String key = message.username() + message.timestamp();

        Message previous = notNeedForMoreThanAMap.get(key);
        if (previous != null) {
            throw new MessageAlreadyExistsException(message);
        }

        notNeedForMoreThanAMap.put(key, message);
    }

    public void updateMessageText(Message message) {

        String key = message.username() + message.timestamp();

        Message previous = notNeedForMoreThanAMap.get(key);
        if (previous == null) {
            throw new MessageDoesNotExistException(message);
        }

        notNeedForMoreThanAMap.put(key, message);
    }

    public void deleteMessage(String username, long timestamp) {
        notNeedForMoreThanAMap.remove(username + timestamp);
    }

}
