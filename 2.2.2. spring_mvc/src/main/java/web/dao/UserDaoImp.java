package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImp<unchecked> implements UserDao {

//   @Autowired
//   private EntityManager em;

   @Override
   public List<User> allUsers() {
//      Transaction transaction = null;
//      Session session = null;
//      List<User> users = null;
//
//      try {
//         session = em.unwrap(Session.class);
//         transaction = session.beginTransaction();
//         users = session.createCriteria(User.class).list();
//         transaction.commit();
//      } catch (Exception ex) {
//         ex.printStackTrace();
//         transaction.rollback();
//      } finally {
//         session.close();
//         return users;
//      }
      return null;
   }

   @Override
   public void add(User user) {
//      Transaction transaction = null;
//      Session session = null;
//      try {
//         session = em.unwrap(Session.class);
//         transaction = session.beginTransaction();
//         session.save(user);
//         transaction.commit();
//      } catch (Exception ex) {
//         ex.printStackTrace();
//         transaction.rollback();
//      } finally {
//         session.close();
//      }

   }

   @Override
   public void delete(User user) {
//      Transaction transaction = null;
//      Session session = null;
//      try {
//         session = em.unwrap(Session.class);
//         transaction = session.beginTransaction();
//         session.remove(user.getId());
//         transaction.commit();
//      } catch (Exception ex) {
//         ex.printStackTrace();
//         transaction.rollback();
//      } finally {
//         session.close();
//      }
   }

   @Override
   public void edit(User user) {
//      Transaction transaction = null;
//      Session session = null;
//      try {
//         session = em.unwrap(Session.class);
//         transaction = session.beginTransaction();
//         session.saveOrUpdate(user); //.put(user.getId(), user);
//         transaction.commit();
//      } catch (Exception ex) {
//         ex.printStackTrace();
//         transaction.rollback();
//      } finally {
//         session.close();
//      }
   }

   @Override
   public User getById(int id) {
//      try {
//         String query = "SELECT * FROM User";
//         em.createQuery(
//                 "SELECT c FROM User c WHERE c.id = number")
//                 .setParameter("number", id)
//                 .getResultList();
//      }
//
//
//         while (resultSet.next()) {
//            String userName = resultSet.getString("name");
//            String userLastName = resultSet.getString("lastName");
//            byte userAge = resultSet.getByte("age");
//            User user = new User(userName, userLastName, userAge);
//            users.add(user);
//            System.out.println(user.toString());
//         }
//      } catch (SQLException throwables) {
//         throwables.printStackTrace();
//      }
//
//      return users;
//      return user;
      return null;
   }

//   @Override
//   @SuppressWarnings("unchecked")
//   @Transactional
//   public List<User> listUsers() {
//      Session session = sessionFactory.getCurrentSession();
//      return session.createQuery("from User").list();
//      //TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//      //return query.getResultList();
//   }
//
//   @Override
//   @Transactional
//   public void add(User user) {
//      Session session = sessionFactory.getCurrentSession();
//      session.persist(user);
//   }
//
//   @Override
//   @Transactional
//   public void delete(User user) {
//      Session session = sessionFactory.getCurrentSession();
//      session.delete(user);
//   }
//
//   @Override
//   @Transactional
//   public void edit(User user) {
//      Session session = sessionFactory.getCurrentSession();
//      session.update(user);
//   }
//
//   @Override
//   @Transactional
//   public User getById(int id) {
//      Session session = sessionFactory.getCurrentSession();
//      return (User) session.get(User.class, id);
//   }

}
