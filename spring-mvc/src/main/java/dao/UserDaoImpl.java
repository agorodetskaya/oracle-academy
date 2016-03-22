package dao;

import model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserDaoImpl implements UserDao {
    private ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(0);

    @Override
    public User create(User user) {
        long id = getNewId();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    private long getNewId() {
        return nextId.getAndIncrement();
    }

    @Override
    public User getById(Long id) {
        return users.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User update(User user) {
        long id = user.getId();
        return users.replace(id, user);
    }

    @Override
    public boolean delete(User user) {
        long id = user.getId();
        return (users.remove(id) != null);
    }
}
