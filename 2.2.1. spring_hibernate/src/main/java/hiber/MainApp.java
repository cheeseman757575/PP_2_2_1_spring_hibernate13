package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.CacheRequest;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
//
//      Car car = new Car("Lamborgini", 999);
//      User user = new User("Bob","Hrenov", "user1@mail.ru");
//
//      car.setUser(user);
//      user.setCar(car);
//
//      userService.add(user);
//
//      user = userService.getUserCar(car);

      //userService.addCar(new Car());

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//      userService.addCar(new Car("Mersedes1", 120));
//      userService.addCar(new Car("Mersedes2", 220));
//      userService.addCar(new Car("Mersedes3", 320));
//      userService.addCar(new Car("Mersedes4", 420));


//      new User().setCar(new Car());

      User user = new User("Bob","Hrenov", "user1@mail.ru");
      Car car = new Car("Lamborgini", 999);
      car.setUser(user);
      user.setCar(car);

      userService.add(user);
      user = userService.getUserCar(car);




//      User user2 = userService.getUserCar(car);
//      System.out.println(user2);


//         List<User> users = userService.getUsersList();
//
//         User user1 = users.get(users.size() - 1);
//         userService.delete(user1);






//         List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();

   }
}
