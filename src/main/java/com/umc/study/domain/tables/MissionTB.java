package com.umc.study.domain.tables;

import jakarta.persistence.*;
import lombok.*;
import com.umc.study.domain.common.BaseEntity;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.domain.enums.PointType;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionTB extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 30)
    private String storeName;

    private Integer price;

    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'POINT'")
    private PointType pointType;

    @Column(nullable = false, length = 100)
    private String content;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'PROGRESS'")
    private MissionStatus missionStatus;

}