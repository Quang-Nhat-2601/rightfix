package com.app.rightfix.dao;

import com.app.rightfix.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO{
    private final EntityManager entityManager;

    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Address address) {
        entityManager.persist(address);
    }

    @Override
    public Address findById(Long id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT * FROM ADDRESS", Address.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Override
    @Transactional
    public void delete(Address address) {
        entityManager.remove(address);
    }
}
