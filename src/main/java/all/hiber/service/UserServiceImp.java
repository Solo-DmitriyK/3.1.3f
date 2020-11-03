package all.hiber.service;

import all.hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> allUsers() {
       return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        User user = getById(id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void edit(long id, User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}
