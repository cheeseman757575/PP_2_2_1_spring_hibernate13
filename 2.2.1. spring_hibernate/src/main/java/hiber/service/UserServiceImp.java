package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

   @Service
    public class UserServiceImp implements UserService {
    private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {

       this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional
   @Override
   public void addCar(Car car){
      userDao.addCar(car);
   }

   @Override
   public void addUserCar(Car car) {userDao.addCar(car);


   }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers(); //ну не null же!
    }
    @Transactional
    @Override
  public void delete (User user) {userDao.delete(user);
   }


   @Transactional(readOnly = true)
   @Override
   public List<User> getUsersList() {
      return userDao.getUsersList();
   }



   @Transactional
   @Override
   public User getUserCar(String model, int series) {
      return userDao.getUserCar(model, series);
   }


}
