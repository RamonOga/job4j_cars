package ru.job4j_cars.store;

import ru.job4j_cars.model.car.Mark;

import java.util.List;

public class MarkStore {
    private final HbrService service = HbrService.instOf();


    public void add(Mark mark) {
        service.add(mark);
    }

    public List<Mark> findAll() {
        return service.tx(session -> session
                .createQuery("from Mark")
                .list());
    }

    public Mark findById(String id) {
        return (Mark) service.tx(session -> session
                .createQuery("from Mark where id = :id")
                .setParameter("id", Integer.parseInt(id))
                .uniqueResult());
    }
}
