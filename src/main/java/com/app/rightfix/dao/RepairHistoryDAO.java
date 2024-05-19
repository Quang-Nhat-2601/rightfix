package com.app.rightfix.dao;

import com.app.rightfix.Entities.RepairHistory;

public interface RepairHistoryDAO {
    void save(RepairHistory repairHistory);
    RepairHistory findRepairHistoryById(long id);
}
