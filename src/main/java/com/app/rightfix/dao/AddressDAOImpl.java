package com.app.rightfix.dao;

import com.app.rightfix.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO{
    private EntityManager entityManager;

    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Address address) {
        entityManager.persist(address);
    }
}
