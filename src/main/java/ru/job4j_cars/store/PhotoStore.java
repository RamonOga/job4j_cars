package ru.job4j_cars.store;

import ru.job4j_cars.model.Photo;

import java.util.List;

public class PhotoStore {
    private final HbrService service = HbrService.instOf();

    public void add(Photo photo) {
        service.add(photo);
    }

    public List<Photo> findAll() {
        return service.tx(session -> session
                .createQuery("from Photo")
                .list());
    }

    public Photo findById(String id) {
        return (Photo) service.tx(session -> session
                .createQuery("from Photo where id = :id")
                .setParameter("id", Integer.parseInt(id))
                .uniqueResult());
    }
}
