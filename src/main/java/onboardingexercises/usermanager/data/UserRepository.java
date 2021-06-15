package onboardingexercises.usermanager.data;

import onboardingexercises.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository
{
    public User save(User user);

    public List<User> findAll();

}
