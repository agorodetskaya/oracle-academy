package services;

import dao.UserDaoImpl;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User createUser (User user){
        return userDao.create(user);
    }

    public User getUserById (Long id) {
        return userDao.getById(id);
    }

    public User updateUser (User user) {
        return userDao.update(user);
    }

    public boolean deleteUser (Long id) {
        User user = userDao.getById(id);
        return userDao.delete(user);
    }

}
