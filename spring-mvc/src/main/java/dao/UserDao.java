package dao;

import model.User;

import java.util.Collection;


public interface UserDao {

    User create(User user);

    User getById(Long id);

    boolean delete(User user);

    User update(User user);

    Collection<User> getAll();

}
