package onboardingexercises.usermanager.service;

import onboardingexercises.usermanager.api.UserController;
import onboardingexercises.usermanager.data.UserRepository;
import onboardingexercises.usermanager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        logger.info(String.format("%d users fetched", result.size()));
        return userRepository.findAll();
    }

    public User save(User user) {
        User result = userRepository.save(user);
        logger.info("New user created: " + result);
        return userRepository.save(user);
    }
}