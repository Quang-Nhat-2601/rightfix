package com.app.rightfix.dao;

import com.app.rightfix.Entities.RepairHistory;
import jakarta.persistence.EntityManager;

public class RepairHistoryDAOImpl implements RepairHistoryDAO{
    private EntityManager entityManager;

    public RepairHistoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(RepairHistory repairHistory) {
        entityManager.persist(repairHistory);
    }
}
