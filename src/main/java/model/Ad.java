package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ad")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private Car car;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();
    private boolean actual = true;

    public static Ad of(String description, Car car) {
        Ad rsl = new Ad();
        rsl.setDescription(description);
        rsl.setCar(car);
        return rsl;
    }

    public void addPhoto(Photo photo) {
        this.photos.add(photo);
    }
}
