package micu.andrei.model;

/**
 * This is not how I write code normally. In this case I just try to fit in a timebox.
 */
public record Message(
        String username,
        String text,
        long timestamp
) {}
