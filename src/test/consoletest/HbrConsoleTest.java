package consoletest;

import ru.job4j_cars.model.car.Body;
import ru.job4j_cars.model.car.Car;
import ru.job4j_cars.model.car.Mark;
import ru.job4j_cars.store.BodyStore;
import ru.job4j_cars.store.CarStore;
import ru.job4j_cars.store.HbrService;
import ru.job4j_cars.store.MarkStore;

public class HbrConsoleTest {
    public static void main(String[] args) {
        MarkStore markStore = new MarkStore();
        BodyStore bodyStore = new BodyStore();
        CarStore carStore = new CarStore();

        Mark mark = Mark.of("MarkName1");
        Body body = Body.of("BodyName1");
        Car car = Car.of("CarName1", mark, body);

        carStore.add(car);
        markStore.add(mark);
        //bodyStore.add(body);


        System.out.println(carStore.findAll());
        System.out.println(carStore.findById("1"));
    }
}
