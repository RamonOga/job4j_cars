package ru.job4j_cars.store;

import ru.job4j_cars.model.Ad;
import ru.job4j_cars.model.car.Body;
import ru.job4j_cars.model.car.Mark;

import java.util.*;

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
            List<Ad> ads = service.tx(session -> session
                    .createQuery(
                            "select distinct a from Ad a " +
                                    "join fetch a.photos where a.car.mark.name = :mark"
                    ).setParameter("mark", mark.getName())
                    .list());
            return ads;
        }

        public List<Ad> findWithPhoto() {
            return service.tx(session -> session
                    .createQuery(
                            "select distinct a from Ad a " +
                                    "join fetch a.photos where a.photos.size > 0"
                    ).list());
        }

        public List<Ad> findToday() {
            Calendar cal = new GregorianCalendar();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return service.tx(session -> session
                    .createQuery(
                            "select distinct a from Ad a " +
                                    "join fetch a.photos " +
                                    "where year(a.created) = :y " +
                                    "and month(a.created) = :m " +
                                    "and day(a.created) = :d "
                    ).setParameter("y" , year)
                    .setParameter("m" , month)
                    .setParameter("d" , day)
                    .list());
        }

   /* public Date getDay() {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        return service.tx(session -> session
                .createQuery(
                        "select distinct a.created from Ad a " +
                                "join fetch a.photos " +
                                "where year(a.created) = :y", Date.class
                ).setParameter("y" , year));
    }*/
}
