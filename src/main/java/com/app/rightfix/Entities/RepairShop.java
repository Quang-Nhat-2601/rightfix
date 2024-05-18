package com.app.rightfix.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
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

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;

    @Column(name="created_at")
    private Instant createdAt;

    @Column(name="delete_flag")
    private Boolean deleteFlag;

    @OneToMany(mappedBy = "repairShop", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<RepairHistory> repairHistoryList;

    public RepairShop(String name) {
        this.name = name;
        this.deleteFlag = false;
    }
}
