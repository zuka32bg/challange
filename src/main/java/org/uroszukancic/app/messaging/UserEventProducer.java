package messaging;

import model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class UserEventProducer {

    @Inject
    @Channel("user-out")
    Emitter<User> publisher;

    public void publishCreatedUser(User user) {
        publisher.send(user);
    }
}