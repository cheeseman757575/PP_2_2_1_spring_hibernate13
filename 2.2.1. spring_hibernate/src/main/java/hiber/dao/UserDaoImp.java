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
   private SessionFactory sessionFactory;

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

   @Override
   public void delete (User user) {
      sessionFactory.getCurrentSession().delete(user);
   }

   @Override
   public User getUserCar(String model, int series) {
      Query query = sessionFactory.getCurrentSession().createQuery(
              "Select u From User u JOIN u.car c where c.model = :model AND c.series = :series");

      query.setParameter("model", model);
      query.setParameter("series", series);
//      Pair pair = Pair.of("model", car.getModel());
//      query.setParameter(pair.fst, pair.snd);
      return (User) query.getSingleResult();
   }

   @Override
   public List<User> getUsersList() {
      return null;
   }

}
