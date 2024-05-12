package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;
//   private String model;
//   private int series;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void addCar(Car car) {sessionFactory.getCurrentSession().save(car);}



   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

//   public List<User> getUserByCar(Collection<String> model, Collection<Integer> series);
   @Override
   public User getUserCar(Car car) {
      Query query = sessionFactory.getCurrentSession().createQuery(
              "Select user From User user JOIN user.car car where car.model = :model AND car.series = :series");

      query.setParameter("model", car);
      query.setParameter("series", car);
      return (User) query.getSingleResult();
   }

}
