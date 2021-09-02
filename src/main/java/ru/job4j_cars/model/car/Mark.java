package ru.job4j_cars.model.car;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public static Mark of(String name) {
        Mark rsl = new Mark();
        rsl.setName(name);
        return rsl;
    }
}
