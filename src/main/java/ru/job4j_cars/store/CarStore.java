package ru.job4j_cars.store;

import ru.job4j_cars.model.car.Car;
import ru.job4j_cars.model.car.Mark;

import java.util.List;

public class CarStore {
    private final HbrService service = HbrService.instOf();

    public void add(Car car) {
        service.add(car);
    }

    public List<Car> findAll() {
        return service.tx(session -> session
                .createQuery("from Car")
                .list());
    }

    public Car findById(String id) {
        return (Car) service.tx(session -> session
                .createQuery("from Car where id = :id")
                .setParameter("id", Integer.parseInt(id))
                .uniqueResult());
    }
}
