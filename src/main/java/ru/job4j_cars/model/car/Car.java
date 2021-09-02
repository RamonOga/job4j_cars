package ru.job4j_cars.model.car;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Mark mark;
    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;

    public static Car of(String name, Mark mark, Body body) {
        Car rsl = new Car();
        rsl.setName(name);
        rsl.setMark(mark);
        rsl.setBody(body);
        return rsl;
    }
}
