package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void delete(int id);

    void edit(User user);

    List<User> allUsers();

    User getById(int id);

    User getUserByName(String s);
}
