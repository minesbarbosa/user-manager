package onboardingexercises.usermanager.data;

import onboardingexercises.usermanager.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("production")
public interface JpaUserRepository extends JpaRepository<User,Long>, UserRepository  {

}
