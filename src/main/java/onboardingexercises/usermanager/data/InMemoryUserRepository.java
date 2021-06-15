package onboardingexercises.usermanager.data;

import onboardingexercises.usermanager.model.User;

import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    public InMemoryUserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public User save(User user) {
        users.add(user);

        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
