package com.app.rightfix.dao;

import com.app.rightfix.entity.RepairHistory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairHistoryDAOImpl implements RepairHistoryDAO{
    private final EntityManager entityManager;

    @Autowired
    public RepairHistoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(RepairHistory repairHistory) {
        entityManager.persist(repairHistory);
    }

    @Override
<<<<<<< HEAD
    public RepairHistory findById(Long id) {
        return entityManager.find(RepairHistory.class, id);
    }

    @Override
    public List<RepairHistory> findAll() {
        return entityManager.createQuery("SELECT a FROM repair_history a", RepairHistory.class).getResultList();
    }

    @Override
    @Transactional
    public void update(RepairHistory repairHistory) {
        entityManager.merge(repairHistory);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(id);
    }
=======
    public RepairHistory findRepairHistoryById(long id) {
        return entityManager.find(RepairHistory.class, id);
    }
>>>>>>> main
}
