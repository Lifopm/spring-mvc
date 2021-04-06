package web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import web.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);

//    @Query("select u from User u where u.name = :name")
//    User findByName(@Param("name") String name);
}