package onboardingexercises.usermanager;

import java.util.List;

import onboardingexercises.usermanager.data.JpaUserRepository;
import onboardingexercises.usermanager.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import onboardingexercises.usermanager.model.*;

@RestController
public class UserController {

    @Autowired
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User user) {
        return repository.save(user);
    }
}