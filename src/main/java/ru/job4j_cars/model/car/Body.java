package ru.job4j_cars.model.car;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public static Body of(String name) {
        Body rsl = new Body();
        rsl.setName(name);
        return rsl;
    }
}
