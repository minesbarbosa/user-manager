package onboardingexercises.usermanager.api;

import java.util.List;

import onboardingexercises.usermanager.data.UserRepository;
import onboardingexercises.usermanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import onboardingexercises.usermanager.model.*;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> all() {
        List<User> result = userService.findAll();
        logger.info(String.format("Getting %d users ", result.size()));
        return result;
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        User result = userService.save(user);
        userService.findAllForceRefresh();
        logger.info("New user created");
        return result;
    }
}