package com.app.rightfix.dao;

import com.app.rightfix.Entities.RepairShop;

public interface RepairShopDAO {
    void save(RepairShop repairShop);
    RepairShop findRepairShopById(long id);
}
