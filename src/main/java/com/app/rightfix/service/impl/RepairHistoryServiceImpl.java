package com.app.rightfix.service.impl;

import com.app.rightfix.dao.RepairHistoryDAO;
import com.app.rightfix.entity.RepairHistory;
import com.app.rightfix.service.RepairHistoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RepairHistoryServiceImpl implements RepairHistoryService {
    private final RepairHistoryDAO repairHistoryDAO;
    @Autowired
    public RepairHistoryServiceImpl(RepairHistoryDAO repairHistoryDAO) {
        this.repairHistoryDAO = repairHistoryDAO;
    }



    @Override
    public void saveRepairHistory(RepairHistory repairHistory) {
        repairHistoryDAO.save(repairHistory);
    }

    @Override
    public RepairHistory getRepairHistoryById(Long id) {
        return repairHistoryDAO.findById(id);
    }

    @Override
    public List<RepairHistory> getAllRepairHistory() {
        return repairHistoryDAO.findAll();
    }

    @Override
    public void updateRepairHistory(RepairHistory repairHistory) {
        repairHistoryDAO.update(repairHistory);
    }

    @Override
    public void deleteRepairHistory(Long id) {
        repairHistoryDAO.delete(id);
    }
}
