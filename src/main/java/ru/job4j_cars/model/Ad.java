package ru.job4j_cars.model;

import lombok.Data;
import ru.job4j_cars.model.car.Car;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "ad")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @OneToOne
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Photo> photos = new HashSet<>();
    private boolean actual = true;
    @Temporal(TemporalType.DATE)
    private Date created = new Date(System.currentTimeMillis());

    public static Ad of(String description, Car car) {
        Ad rsl = new Ad();
        rsl.setDescription(description);
        rsl.setCar(car);
        return rsl;
    }

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id
                && actual == ad.actual
                && Objects.equals(description, ad.description)
                && Objects.equals(car, ad.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, car, actual);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", car=" + car +
                ", photos=" + photos +
                ", actual=" + actual +
                ", created=" + created +
                '}' + System.lineSeparator();
    }
}
