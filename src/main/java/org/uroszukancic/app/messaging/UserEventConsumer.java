package messaging;

import model.User;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class UserEventConsumer {

    private static final Logger LOG = Logger.getLogger(UserEventConsumer.class);

    @Incoming("user-in")
    public void consume(User user) {
        LOG.infof("Received event from Kafka 'data': id=%d, firstName=%s, lastName=%s, email=%s",
                user.id, user.firstName, user.lastName, user.email);
    }
}