package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp<unchecked> implements UserDao {

   @Autowired
   private EntityManagerFactory entityManagerFactory;

   @Override
   @Transactional
   public List<User> allUsers() {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      return entityManager.createQuery("SELECT e FROM User e").getResultList();
   }

   @Override
   @Transactional
   public void add(User user) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.persist(user);
      entityManager.getTransaction().commit();
   }

   @Override
   @Transactional
   public void delete(int id) {
      User user = getById(id);

      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.remove(user);
      entityManager.getTransaction().commit();
   }

   @Override
   @Transactional
   public void edit(User user) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.merge(user);
      entityManager.getTransaction().commit();
   }

   @Override
   @Transactional
   public User getById(int id) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      User user = entityManager.find(User.class, id);
      entityManager.getTransaction().commit();
      return user;
   }
}
