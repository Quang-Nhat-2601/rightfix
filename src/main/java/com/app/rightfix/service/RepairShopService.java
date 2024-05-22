package com.app.rightfix.service;



import com.app.rightfix.entity.RepairShop;

import java.util.List;

public interface RepairShopService {
    // Create
    void saveRepairShop(RepairShop repairShop);

    // Read
    RepairShop getRepairShopById(Long id);

    List<RepairShop> getAllRepairShop();

    // Update
    void updateRepairShop(RepairShop repairShop);

    // Delete
    void deleteRepairShop(Long id);
}
