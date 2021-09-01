package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ad> ads = new ArrayList<>();

    public static User of(String login, String password) {
        User rsl = new User();
        rsl.setLogin(login);
        rsl.setPassword(password);
        return rsl;
    }

    public void addAd(Ad ad) {
        ads.add(ad);
    }
}
