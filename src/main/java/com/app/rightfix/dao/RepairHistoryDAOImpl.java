package com.app.rightfix.dao;

import com.app.rightfix.entity.RepairHistory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepairHistoryDAOImpl implements RepairHistoryDAO{
    private EntityManager entityManager;

    @Autowired
    public RepairHistoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(RepairHistory repairHistory) {
        entityManager.persist(repairHistory);
    }
}
