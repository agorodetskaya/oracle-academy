package service;

import dao.UserDaoImpl;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public Collection<User> getAll() {
        return userDao.getAll();
    }

    public User createUser(User user) {
        return userDao.create(user);
    }

    public User updateUser(User user) {
        return userDao.update(user);
    }

    public boolean deleteUser(Long id) {
        User user = userDao.getById(id);
        return userDao.delete(user);
    }

}
