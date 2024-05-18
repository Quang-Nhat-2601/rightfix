package com.app.rightfix.Entities;

import com.app.rightfix.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "dob")
    private Instant dob;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="created_at")
    private Instant createdAt;

    @Column(name="delete_flag")
    private Boolean deleteFlag;

    @OneToMany(mappedBy = "user", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<RepairHistory> repairHistoryList;

    public User(String fullName, Gender gender, Instant dob, String email, String password) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.createdAt = Instant.now();
        this.deleteFlag = false;
    }
}
