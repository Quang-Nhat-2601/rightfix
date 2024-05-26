package com.app.rightfix.dao;

import com.app.rightfix.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user); // This will also save the Address
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Optional<User> findByName(String email) {
        return Optional.ofNullable(entityManager.createQuery(
                        "SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult());
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT a FROM app_user a", User.class).getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(id);
    }
}
