package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    void add(User user);

    void addCar(Car car);

    void delete (User user);


    void addUserCar(Car car);

    default User getUserCar(Car car) {return null;}

//    public List<User> getUserByCar(Collection<String> model, Collection<Integer> series);

    List<User> getUsersList();
}
