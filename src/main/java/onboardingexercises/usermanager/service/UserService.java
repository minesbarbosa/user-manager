package onboardingexercises.usermanager.service;

import onboardingexercises.usermanager.data.UserRepository;
import onboardingexercises.usermanager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"users"})
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable
    public List<User> findAll() {
        List<User> result = userRepository.findAll();
        logger.info(String.format("operation='findAll' msg='%d users fetched'", result.size()));
        return result;
    }

    @CachePut
    public List<User> findAllUsers() {
        List<User> result = userRepository.findAll();
        logger.info(String.format("operation='findAllUsers msg='%d users fetched'", result.size()));
        return result;
    }

    public User save(User user) {
        User result = userRepository.save(user);
        logger.info("operation='save' msg='New user created: '" + result);
        findAllUsers();
        return result;
    }

    /*  private void putUserInCache(String cacheName, User user) {
        cacheManager.getCache(cacheName).put(user.getId(), user);
    }*/
}