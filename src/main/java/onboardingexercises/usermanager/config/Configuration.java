package onboardingexercises.usermanager.config;

import onboardingexercises.usermanager.data.InMemoryUserRepository;
import onboardingexercises.usermanager.data.UserRepository;
import onboardingexercises.usermanager.model.User;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class Configuration {

    @Bean
    List<User> initInMemoryDatabase() {

        return new ArrayList<User>(
                List.of(new User(1L, "Ana InMem"),
                        new User(2L, "Carlos InMem")));
    }

    @Bean
    @Profile("!production")
    UserRepository getUserRepository() {
        return new InMemoryUserRepository(initInMemoryDatabase());
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("users",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(60)));
    }
}