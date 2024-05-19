package com.app.rightfix.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "street")
    private String street;
    @Column(name = "ward")
    private String ward;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
    @Column(name="created_at",nullable = false)
    private Instant createdAt = Instant.now();
    @Column(name="delete_flag", nullable = false)
    private Boolean deleteFlag = false;

    public Address(String street, String ward, String district, String city) {
        this.street = street;
        this.ward = ward;
        this.district = district;
        this.city = city;
        this.createdAt = Instant.now();
        this.deleteFlag = false;
    }
}
