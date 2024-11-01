package com.umc.study.domain.tables;

import jakarta.persistence.*;
import lombok.*;
import com.umc.study.domain.common.BaseEntity;
import com.umc.study.domain.enums.StoreOpen;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String storeName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 100)
    private String pic;

    private Float score;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'OPEN'")
    private StoreOpen storeOpen;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<MissionTB> missionTbList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>();
}