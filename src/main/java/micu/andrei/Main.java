package micu.andrei;

import micu.andrei.resources.MessagesResource;
import micu.andrei.store.MessageStore;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is not how I write code normally. In this case I just try to fit in a timebox.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        MessagesResource messagesResource = new MessagesResource(new MessageStore());

        ResourceConfig config = new ResourceConfig();
        config.registerInstances(messagesResource);

        Server server = JettyHttpContainerFactory.createServer(URI.create("http://localhost:8080/"), config);

        try {
            server.start();
            logger.log(Level.INFO, "Started!");
            server.join();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            server.destroy();
        }
    }
}