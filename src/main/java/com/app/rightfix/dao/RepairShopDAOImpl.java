package com.app.rightfix.dao;

import com.app.rightfix.entity.RepairShop;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairShopDAOImpl implements RepairShopDAO{
    private final EntityManager entityManager;

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
<<<<<<< HEAD
    public RepairShop findById(Long id) {
        return entityManager.find(RepairShop.class, id);
    }

    @Override
    public List<RepairShop> findAll() {
        return entityManager.createQuery("SELECT a FROM repair_shop a", RepairShop.class).getResultList();
    }

    @Override
    @Transactional
    public void update(RepairShop repairShop) {
        entityManager.merge(repairShop);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(id);
    }
=======
    public RepairShop findRepairShopById(long id) {
        return entityManager.find(RepairShop.class, id);
    }
>>>>>>> main
}
