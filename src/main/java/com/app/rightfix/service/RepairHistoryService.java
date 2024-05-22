package com.app.rightfix.service;

import com.app.rightfix.entity.RepairHistory;

import java.util.List;

public interface RepairHistoryService {
    // Create
    void saveRepairHistory(RepairHistory repairHistory);

    // Read
    RepairHistory getRepairHistoryById(Long id);

    List<RepairHistory> getAllRepairHistory();

    // Update
    void updateRepairHistory(RepairHistory repairHistory);

    // Delete
    void deleteRepairHistory(Long id);
}
