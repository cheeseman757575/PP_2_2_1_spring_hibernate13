package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.Collection;
import java.util.List;

public interface UserDao {
   void add(User user);
   void addCar(Car car);

   List<User> listUsers();

   default User getUserCar(Car car) {
      return null;
   }
//   public List<User> getUserByCar(Collection<String> model, Collection<Integer> series);
}
