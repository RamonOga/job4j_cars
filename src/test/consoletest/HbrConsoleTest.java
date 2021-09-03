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

        Mark mark1 = Mark.of("KIA");
        Mark mark2 = Mark.of("BMW");
        Body body = Body.of("BodyName1");
        Car car1 = Car.of("rio", mark1, body);
        Car car2 = Car.of("passat", mark2, body);

        Photo photo1 = Photo.of("img/img1.png");
        Photo photo2 = Photo.of("img/img2.png");
        Ad ad1 = Ad.of("Description1", car1);
        Ad ad2 = Ad.of("Description1", car2);
        User user = User.of("login", "password");

        ad1.addPhoto(photo1);
        ad2.addPhoto(photo2);
        user.addAd(ad1);
        user.addAd(ad2);


        markStore.add(mark1);
        markStore.add(mark2);
        bodyStore.add(body);
        carStore.add(car1);
        carStore.add(car2);
        photoStore.add(photo1);
        photoStore.add(photo2);
        adStore.add(ad1);
        adStore.add(ad2);
        userStore.add(user);



        System.out.println(userStore.findAll());
        System.out.println(adStore.findByMark(mark1));
    }
}
