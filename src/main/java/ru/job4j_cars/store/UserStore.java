package ru.job4j_cars.store;

import ru.job4j_cars.model.Ad;
import ru.job4j_cars.model.User;

import java.util.List;

public class UserStore {
    private final HbrService service = HbrService.instOf();

    public void add(User user) {
        service.add(user);
    }

    public List<User> findAll() {
        return service.tx(session -> session
                .createQuery(
                        "select distinct u from User u " +
                                "join fetch u.ads a " +
                                "join fetch a.photos"
                ).list());
    }

    public User findById(String id) {
        return (User) service.tx(session -> session
                .createQuery(
                        "select distinct u from User u " +
                                "join fetch u.ads a " +
                                "join fetch a.photos where u.id = :id"
                ).setParameter("id", Integer.parseInt(id))
                .setMaxResults(1)
                .uniqueResult());
    }
}
