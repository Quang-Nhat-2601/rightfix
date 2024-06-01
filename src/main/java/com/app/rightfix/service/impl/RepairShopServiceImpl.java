package com.app.rightfix.service.impl;

import com.app.rightfix.dao.RepairShopDAO;
import com.app.rightfix.entity.RepairShop;
import com.app.rightfix.service.RepairShopService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RepairShopServiceImpl implements RepairShopService {
    private final RepairShopDAO repairShopDAO;
    @Autowired
    public RepairShopServiceImpl(RepairShopDAO repairShopDAO) {
        this.repairShopDAO = repairShopDAO;
    }

    @Override
    public void saveRepairShop(RepairShop repairShop) {
        repairShopDAO.save(repairShop);
    }

    @Override
    public RepairShop getRepairShopById(Long id) {
        return repairShopDAO.findById(id);
    }

    @Override
    public List<RepairShop> getAllRepairShop() {
        return repairShopDAO.findAll();
    }

    @Override
    public void updateRepairShop(RepairShop repairShop) {
        repairShopDAO.update(repairShop);
    }

    @Override
    public void deleteRepairShop(Long id) {
        repairShopDAO.delete(id);
    }
}
