package com.app.rightfix.dao;

import com.app.rightfix.Entities.RepairShop;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class RepairShopDAOImpl implements RepairShopDAO{
    private EntityManager entityManager;

    public RepairShopDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(RepairShop repairShop) {
        entityManager.persist(repairShop);
    }
}
