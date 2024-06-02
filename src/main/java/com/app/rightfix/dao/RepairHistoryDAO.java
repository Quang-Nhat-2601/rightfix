package com.app.rightfix.dao;

import com.app.rightfix.entity.RepairHistory;

import java.util.List;

public interface RepairHistoryDAO {
    void save(RepairHistory repairHistory);

    RepairHistory findById(Long id);

    List<RepairHistory> findAll();

    void update(RepairHistory repairHistory);

    void delete(Long id);

    RepairHistory findRepairHistoryById(long id);
}
