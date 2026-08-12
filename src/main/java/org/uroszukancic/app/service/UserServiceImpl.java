package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import messaging.UserEventProducer;
import model.User;
import repositorty.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    UserEventProducer eventProducer;

    @Override
    @Transactional
    public User createUser(User user) {
        userRepository.persist(user);
        eventProducer.publishCreatedUser(user);
        return user;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.listAll();
    }
}
