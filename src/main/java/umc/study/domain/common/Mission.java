package umc.study.domain.common;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMissionProgress;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "restaurant_id") // 데이터베이스 컬럼 이름
    private Restaurant restaurant;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mission", length = 40, nullable = false)
    private String mission;

    @Column(name = "points_reward")
    private Integer pointsReward;

    @Column(name = "d_day")
    private LocalDate dDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MissionStatus status;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMissionProgress> missionProgressList = new ArrayList<>();
}
