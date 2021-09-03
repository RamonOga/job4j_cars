package ru.job4j_cars.store;

import ru.job4j_cars.model.Ad;
import ru.job4j_cars.model.car.Body;
import ru.job4j_cars.model.car.Mark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdStore {
        private final HbrService service = HbrService.instOf();

        public void add(Ad ad) {
            service.add(ad);
        }

        public List<Ad> findAll() {
            return service.tx(session -> session
                    .createQuery(
                            "select distinct a from Ad a " +
                            "join fetch a.photos"
                    ).list());
        }

        public Ad findById(String id) {
            return (Ad) service.tx(session -> session
                    .createQuery("" +
                            "select distinct a from Ad a " +
                            "join fetch a.photos p" +
                            " where a.id = :id"
                    ).setParameter("id", Integer.parseInt(id))
                    .uniqueResult());
        }

        public List<Ad> findByMark(Mark mark) {
            String m = mark.getName();
            List<Ad> ads = service.tx(session -> session
                    .createQuery(
                            "select distinct a from Ad a " +
                                    "join fetch a.photos where a.car.mark.name = :mark"
                    ).setParameter("mark", m)
                    .list());

            return ads;
        }

        public List<Ad> findWithPhoto() {
            return null;
        }

        public List<Ad> findToday() {
            return null;
        }
    }
