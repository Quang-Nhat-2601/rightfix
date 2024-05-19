package com.app.rightfix.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "repair_history")
@Data
@NoArgsConstructor
public class RepairHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "repair_shop_id", nullable = false)
    private RepairShop repairShop;
    @Column(name = "item_fix")
    private String itemFix;
    @Column(name="is_new_item")
    private Boolean isNewItem;
    @Column(name="cost")
    private double cost;
    @Column(name="date_fix")
    private Instant dateFix;
    @Column(name="created_at")
    private Instant createdAt;
    @Column(name="delete_flag")
    private Boolean deleteFlag;

    public RepairHistory(User user, RepairShop repairShop, String itemFix, Boolean isNewItem, double cost, Instant dateFix) {
        this.user = user;
        this.repairShop = repairShop;
        this.itemFix = itemFix;
        this.isNewItem = isNewItem;
        this.cost = cost;
        this.dateFix = dateFix;
        this.deleteFlag = false;
        this.createdAt = Instant.now();
    }
}
