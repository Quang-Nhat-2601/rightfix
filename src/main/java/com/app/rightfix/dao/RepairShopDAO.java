package com.app.rightfix.dao;


import com.app.rightfix.entity.RepairShop;

import java.util.List;

public interface RepairShopDAO {
    void save(RepairShop repairShop);
<<<<<<< HEAD
    RepairShop findById(Long id);
    List<RepairShop> findAll();
    void update(RepairShop repairShop);
    void delete(Long id);
=======
    RepairShop findRepairShopById(long id);
>>>>>>> main
}
