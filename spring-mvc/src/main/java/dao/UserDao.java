package dao;

import model.User;

import java.util.List;


public interface UserDao {

    User create(User user);

    User getById(Long id);

    boolean delete(User user);

    User update(User user);

    List<User> getAll();

}
