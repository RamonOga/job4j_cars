package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.nio.file.Path;

@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;

    public static Photo of(String path) {
        Photo rsl = new Photo();
        rsl.setPath(path);
        return rsl;
    }
}
