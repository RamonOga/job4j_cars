package consoletest;

import ru.job4j_cars.model.Ad;
import ru.job4j_cars.model.Photo;
import ru.job4j_cars.model.User;
import ru.job4j_cars.model.car.Body;
import ru.job4j_cars.model.car.Car;
import ru.job4j_cars.model.car.Mark;
import ru.job4j_cars.store.*;

public class HbrConsoleTest {
    public static void main(String[] args) {
        MarkStore markStore = new MarkStore();
        BodyStore bodyStore = new BodyStore();
        CarStore carStore = new CarStore();
        PhotoStore photoStore = new PhotoStore();
        AdStore adStore = new AdStore();
        UserStore userStore = new UserStore();

        Mark mark = Mark.of("MarkName1");
        Body body = Body.of("BodyName1");
        Car car = Car.of("CarName1", mark, body);

        Photo photo1 = Photo.of("img/img1.png");
        Photo photo2 = Photo.of("img/img2.png");
        Ad ad = Ad.of("Description1", car);
        User user = User.of("login", "password");

        ad.addPhoto(photo1);
        ad.addPhoto(photo2);
        user.addAd(ad);


        markStore.add(mark);
        bodyStore.add(body);
        carStore.add(car);
        photoStore.add(photo1);
        photoStore.add(photo2);
        adStore.add(ad);
        userStore.add(user);



        System.out.println(userStore.findAll());
        System.out.println(userStore.findById("1"));
    }
}
