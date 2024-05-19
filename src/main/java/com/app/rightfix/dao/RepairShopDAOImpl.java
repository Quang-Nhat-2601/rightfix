package com.app.rightfix.dao;

import com.app.rightfix.Entities.RepairShop;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepairShopDAOImpl implements RepairShopDAO{
    private EntityManager entityManager;

    @Autowired
    public RepairShopDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(RepairShop repairShop) {
        entityManager.persist(repairShop);
    }

    @Override
    public RepairShop findRepairShopById(long id) {
        return entityManager.find(RepairShop.class, id);
    }
}
