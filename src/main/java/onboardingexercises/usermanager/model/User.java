package onboardingexercises.usermanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    private Long id;
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return id + " " + name;
    }
}