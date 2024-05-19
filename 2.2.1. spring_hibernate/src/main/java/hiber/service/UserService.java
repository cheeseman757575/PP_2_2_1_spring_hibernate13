package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);
    void addCar(Car car);
    void delete (User user);

    void addUserCar(Car car);
    List<User> listUsers();

    @Transactional(readOnly = true)
    List<User> getUsersList();

    User getUserCar(String model, int series);

}
