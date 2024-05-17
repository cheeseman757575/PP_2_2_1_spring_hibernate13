package hiber.dao;


import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
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
   public List<User> getUsersList() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<Car> getCarsList() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }
   @Override
   public void delete (User user) {
      sessionFactory.getCurrentSession().delete(user);
   }


   //   public List<User> getUserByCar(Collection<String> model, Collection<Integer> series);
   @Override
   public User getUserCar(Car car) {
      TypedQuery <User> query = sessionFactory.getCurrentSession().createQuery(
              "Select user From User user JOIN FETCH user.car car where car.model = :model AND car.series = :series", User.class);

      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
//      Pair pair = Pair.of("model", car.getModel());
//      query.setParameter(pair.fst, pair.snd);
      return query.setMaxResults(1).getSingleResult();
   }

}
