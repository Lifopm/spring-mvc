//package web.dao;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import web.model.User;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Repository
//public class UserDaoImp implements UserDao {
//
//   @PersistenceContext
//   private EntityManagerFactory entityManagerFactory;
//
//   @Override
//   @Transactional
//   public List<User> allUsers() {
//      EntityManager entityManager = entityManagerFactory.createEntityManager();
//      List<User> allUsers = entityManager.createQuery("SELECT e FROM User e").getResultList();
//      return allUsers;
//   }
//
//   @Override
//   @Transactional
//   public void add(User user) {
//      EntityManager entityManager = entityManagerFactory.createEntityManager();
//      entityManager.getTransaction().begin();
//      entityManager.persist(user);
//      entityManager.getTransaction().commit();
//   }
//
//   @Override
//   @Transactional
//   public void delete(int id) {
//      User user = getById(id);
//
//      EntityManager entityManager = entityManagerFactory.createEntityManager();
//      entityManager.getTransaction().begin();
//      entityManager.remove(user);
//      entityManager.getTransaction().commit();
//   }
//
//   @Override
//   @Transactional
//   public void edit(User user) {
//      EntityManager entityManager = entityManagerFactory.createEntityManager();
//      entityManager.getTransaction().begin();
//      entityManager.merge(user);
//      entityManager.getTransaction().commit();
//   }
//
//   @Override
//   @Transactional
//   public User getById(int id) {
//      EntityManager entityManager = entityManagerFactory.createEntityManager();
//      entityManager.getTransaction().begin();
//      User user = entityManager.find(User.class, id);
//      entityManager.getTransaction().commit();
//      entityManager.close();
//      return user;
//   }
//
//   @Override
//   public User getUserByName(String s) {
//      EntityManager entityManager = entityManagerFactory.createEntityManager();
//      entityManager.getTransaction().begin();
//      List<User> users = entityManager.createQuery("SELECT e FROM User e where e.name = ?1")
//              .setParameter(1, s)
//              .getResultList();
//              //.getSingleResult();
//      entityManager.getTransaction().commit();
//      return users.get(0);
//   }
//}
