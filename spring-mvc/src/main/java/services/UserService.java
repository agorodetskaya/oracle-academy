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

    public void printUser (User user){
        System.out.println(user.getFirstName() + " " + user.getRole());
    }


}
