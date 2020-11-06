package all.hiber.service;

import all.hiber.dao.UserDao;
import all.hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void edit(long id, User user) {
        userDao.edit(id, user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }
}
