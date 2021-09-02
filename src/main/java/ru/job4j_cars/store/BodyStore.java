package ru.job4j_cars.store;

import ru.job4j_cars.model.car.Body;

import java.util.List;

public class BodyStore {
    private final HbrService service = HbrService.instOf();

    public void add(Body body) {
        service.add(body);
    }

    public List<Body> findAll() {
        return service.tx(session -> session
                .createQuery("from Body")
                .list());
    }

    public Body findById(String id) {
        return (Body) service.tx(session -> session
                .createQuery("from Body where id = :id")
                .setParameter("id", Integer.parseInt(id))
                .uniqueResult());
    }
}
