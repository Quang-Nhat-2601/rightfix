package com.app.rightfix.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="repair_shop")
@Data
@NoArgsConstructor
public class RepairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @Column(name="created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name="delete_flag", nullable = false)
    private Boolean deleteFlag = false;

    @OneToMany(mappedBy = "repairShop", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<RepairHistory> repairHistoryList = Collections.emptyList();

    public RepairShop(String name) {
        this.name = name;
        this.deleteFlag = false;
    }

    // set up bidirectional relationship
    public void add(RepairHistory repairHistory) {
        this.repairHistoryList.add(repairHistory);
        repairHistory.setRepairShop(this);
    }
}
