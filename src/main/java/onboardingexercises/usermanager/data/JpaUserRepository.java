package onboardingexercises.usermanager.data;

import onboardingexercises.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User,Long>  {

}
